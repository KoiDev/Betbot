//папка localDB
//
//файл DbHelper.java
//
//public class DbHelper extends SQLiteOpenHelper {
//
//    public static final String DATABASE_NAME = "getserviceDB";
//    public static final int DATABASE_VERSION = 1;
//
//    public static final String TABLE_SERVICES = "services";
//    public static final String SERVICES_ID = "id";
//    public static final String SERVICES_SERVER_ID = "server_id";
//    public static final String SERVICES_NAME = "name";
//    public static final String SERVICES_DESCRIPTION = "description";
//    public static final String SERVICES_FULL_IMAGE = "full_image";
//    public static final String SERVICES_CITY = "city";
//    public static final String SERVICES_ADRESS = "adress";
//    public static final String SERVICES_LAT = "lat";
//    public static final String SERVICES_LNG = "lng";
//    public static final String SERVICES_ORDERING = "ordering";
///*
//   "data": [
//    {
//        "id": "3343009",
//            "league": "Австрия. Кубок. 1/8 финала",
//            "logo_league": "http://vprognoze.ru/uploads/logo_country/0.png",
//            "data": [
//        {
//            "tid": "4674759",
//                "g_id": "2149605",
//                "league": "Австрия. Кубок. 1/8 финала",
//                "sport": "Футбол",
//                "fullresult": "",
//                "date": "1477505700",
//                "home": "Блау-Вайс Линц",
//                "away": "Рапид Вена",
//                "res1": "0",
//                "res2": "0",
//                "id": "97e03cf4a1b0ba219c70c671a1580df9",
//                "league_id": "3343009",
//                "end": "0",
//                "live": "0",
//                "stat": "1"
//        }
//*/
//    final String LOG_TAG = "myLogs";
//
//    public DbHelper(Context context) {
//        // конструктор суперкласса
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        Log.d(LOG_TAG, "--- onCreate database ---");
//        // создаем таблицу с полями
//
//
//        db.execSQL("create table " + TABLE_SERVICES + " ("
//                + SERVICES_ID + " integer primary key autoincrement,"
//                + SERVICES_SERVER_ID + " integer,"
//                + SERVICES_NAME + " text,"
//                + SERVICES_DESCRIPTION + " text,"
//                + SERVICES_FULL_IMAGE + " text,"
//                + SERVICES_CITY + " integer,"
//                + SERVICES_ADRESS + " text,"
//                + SERVICES_LAT + " text,"
//                + SERVICES_LNG + " text,"
//                + SERVICES_ORDERING + " integer" + ");");
//
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }
//}
//
//папка HelpersDB
//файл ServicesDataSource.java
//
//public class ServicesDataSource {
//    private SQLiteDatabase database;
//    private DbHelper dbHelper;
//    private String[] allColumns =
//            {
//                    dbHelper.SERVICES_ID,
//                    dbHelper.SERVICES_SERVER_ID,
//                    DbHelper.SERVICES_NAME,
//                    DbHelper.SERVICES_DESCRIPTION,
//                    DbHelper.SERVICES_FULL_IMAGE,
//                    DbHelper.SERVICES_CITY,
//                    DbHelper.SERVICES_ADRESS,
//                    DbHelper.SERVICES_LAT,
//                    dbHelper.SERVICES_LNG,
//                    DbHelper.SERVICES_ORDERING
//            };
//    public ServicesDataSource(Context context) {
//        dbHelper = new DbHelper(context);
//    }
//
//    public void open() throws SQLException {
//        database = dbHelper.getWritableDatabase();
//    }
//
//    public void close() {
//        dbHelper.close();
//    }
//
//    public Service createService(HashMap<String, String> paramService) {
//        ContentValues values = new ContentValues();
//        for(Map.Entry<String, String> entry : paramService.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            values.put(key, value);
//        }
//        long insertId = database.insert(DbHelper.TABLE_SERVICES, null,
//                values);
//
//        Cursor cursor = database.query(DbHelper.TABLE_SERVICES,
//                allColumns, DbHelper.SERVICES_ID + " = " + insertId, null,
//                null, null, null);
//
//        cursor.moveToFirst();
//        Service newService = cursorToService(cursor);
//        cursor.close();
//        return newService;
//    }
//
//    public Service getServiceByServer_id(Integer server_id) {
//        Cursor cursor = database.query(DbHelper.TABLE_SERVICES,
//                allColumns, DbHelper.SERVICES_SERVER_ID + " = " + server_id, null,
//                null, null, null);
//        cursor.moveToFirst();
//        Service service = cursorToService(cursor);
//        cursor.close();
//        return service;
//    }
//
//    public int countServices() {
//        Cursor cursor = database.query(DbHelper.TABLE_SERVICES, null, null, null, null, null, null);
//        Integer count = cursor.getCount();
//        cursor.close();
//        return count;
//    }
//
//    public void deleteAllServices() {
//        database.delete(DbHelper.TABLE_SERVICES, null, null);
//    }
//
//    public List<Service> getAllServices() {
//        List<Service> services = new ArrayList<>();
//
//        Cursor cursor = database.query(DbHelper.TABLE_SERVICES,
//                allColumns, null, null, null, null, null);
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Service service = cursorToService(cursor);
//            services.add(service);
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return services;
//    }
//
//    //Servise is a model of data for database
//    private Service cursorToService(Cursor cursor) {
//        Service service = new Service();
//        service.setId(cursor.getLong(0));
//        service.setServer_id(cursor.getInt(1));
//        service.setName(cursor.getString(2));
//        service.setDescription(cursor.getString(3));
//        service.setFull_image(cursor.getString(4));
//        service.setCity(cursor.getInt(5));
//        service.setAdress(cursor.getString(6));
//        service.setLat(cursor.getString(7));
//        service.setLng(cursor.getString(8));
//        service.setOrdering(cursor.getInt(9));
//        return service;
//    }
//}
//
//
//
//загрузка в таблицу
//
//
//    datasourceServices = new ServicesDataSource(this);
//datasourceServices.open();
//
//        HashMap<String, String> paramService = new HashMap<>();
//        paramService.put("server_id", service.getServer_id().toString());
//        paramService.put("name", service.getName());
//        paramService.put("description", service.getDescription());
//        paramService.put("full_image", service.getFull_image());
//        paramService.put("city", service.getCity().toString());
//        paramService.put("adress", service.getAdress());
//        paramService.put("lat", service.getLat());
//        paramService.put("lng", service.getLng());
//        paramService.put("ordering", service.getOrdering().toString());
//        datasourceServices.createService(paramService);
//
//
//        datasourceServices.close();