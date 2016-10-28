package ru.gmgspb.betbot.live.sections.localDB;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "getserviceDB";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_GAMES = "games";
    public static final String GAME_DB_ID = "id";
    public static final String SPORT = "sport";
    public static final String GAME_ID = "gameId";
    public static final String LEAGUE = "league";
    public static final String DATA_GAME = "data";
    public static final String HOME = "home";
    public static final String AWAY = "away";
    public static final String RES1 = "res1";
    public static final String RES2 = "res2";
    public static final String LIVE = "live";



    final String LOG_TAG = "myLogs";


    public DbHelper(Context context, String name) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");

        db.execSQL("create table " + TABLE_GAMES + " ("
                + GAME_DB_ID + " integer primary key autoincrement,"
                + GAME_ID + " text,"
                + LEAGUE + " text,"
                + SPORT + " text,"
                + DATA_GAME + " text,"
                + HOME + " integer,"
                + AWAY + " text,"
                + RES1 + " text,"
                + RES2 + " text,"
                + LIVE + " integer" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Realm android, Firebase
}
