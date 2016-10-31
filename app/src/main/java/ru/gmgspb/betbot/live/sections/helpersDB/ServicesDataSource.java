package ru.gmgspb.betbot.live.sections.helpersDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.gmgspb.betbot.live.sections.modeldb.DbFavoritesModel;
import ru.gmgspb.betbot.live.sections.localDB.DbHelper;
import ru.gmgspb.betbot.live.view.LiveActivity;

public class ServicesDataSource {
    private SQLiteDatabase database;
    private DbHelper dbHelper;
    private String[] allColums =
            {
                    dbHelper.GAME_DB_ID,
                    dbHelper.GAME_ID,
                    dbHelper.LEAGUE,
                    dbHelper.SPORT,
                    dbHelper.DATA_GAME,
                    dbHelper.HOME,
                    dbHelper.AWAY,
                    dbHelper.RES1,
                    dbHelper.RES2,
                    dbHelper.LIVE
            };

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
        Log.d("TAG", "--- onOpen database ---");
    }

    public void close() {
        dbHelper.close();
        Log.d("TAG", "--- onClose database ---");
    }

    public DbFavoritesModel createService(HashMap<String, String> paramService) {
        ContentValues values = new ContentValues();
        for (Map.Entry<String, String> entry : paramService.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            values.put(key, value);
        }
        long insertId = database.insert(DbHelper.TABLE_GAMES, null, values);

        Cursor cursor = database.query(DbHelper.TABLE_GAMES,
                allColums, DbHelper.GAME_DB_ID + " = " + insertId, null,
                null, null, null); //TODO repair this
        cursor.moveToFirst();
        DbFavoritesModel newService = cursorToService(cursor);
        return newService;
    }

    public DbFavoritesModel getGameByGame_id(String gameId) {
        Cursor cursor = database.query(DbHelper.TABLE_GAMES,
                allColums, DbHelper.GAME_ID + " + " + gameId, null,
                null, null, null);
        cursor.moveToFirst();
        DbFavoritesModel service = cursorToService(cursor);
        cursor.close();
        return service;
    }

    public boolean isGameFavorite(String gameId) {
        Cursor cursor = database.query(DbHelper.TABLE_GAMES,
                allColums, DbHelper.GAME_ID + " + " + gameId, null,
                null, null, null);
        cursor.moveToFirst();
        DbFavoritesModel service = null;
        service = cursorToService(cursor);
        cursor.close();
        if (service == null) {
            return false;
        } else {
            return true;
        }
    }

    public int countGames() {
        Cursor cursor = database.query(DbHelper.TABLE_GAMES, null, null, null, null, null, null);
        Integer count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void deleteAllServices() {
        database.delete(DbHelper.TABLE_GAMES, null, null);
    }

    public List<DbFavoritesModel> getAllGames() {
        List<DbFavoritesModel> services = new ArrayList<>();
        Cursor cursor = database.query(DbHelper.TABLE_GAMES, allColums,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            DbFavoritesModel service = cursorToService(cursor);
            services.add(service);
            cursor.moveToNext();
        }
        cursor.close();
        return services;
    }

    private DbFavoritesModel cursorToService(Cursor cursor) {

        DbFavoritesModel
                serviceDetails = new DbFavoritesModel();
        serviceDetails.setId(cursor.getInt(0));
        serviceDetails.setIdGame(cursor.getString(1));
        serviceDetails.setLeague(cursor.getString(2));
        serviceDetails.setSport(cursor.getString(3));
        serviceDetails.setDate(cursor.getString(4));
        serviceDetails.setHome(cursor.getString(5));
        serviceDetails.setAway(cursor.getString(6));
        serviceDetails.setRes1(cursor.getString(7));
        serviceDetails.setRes2(cursor.getString(8));
        serviceDetails.setLive(cursor.getString(9));
        return serviceDetails;
    }
}
