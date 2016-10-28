////package ru.gmgspb.betbot.live.adapter;
////
////import android.support.v7.widget.RecyclerView;
////import android.view.View;
////import android.widget.TextView;
////
////import ru.gmgspb.betbot.R;
////
////public class TvItemViewHolder extends RecyclerView.ViewHolder {
////
////    public final TextView tvItem;
////
////    public TvItemViewHolder(View itemView) {
////        super(itemView);
////
////        tvItem = (TextView) itemView.findViewById(R.id.selection_livelist_item_home_txt);
////    }
////}
//
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
//
//public class Service {
//
//    private long id;
//    private Integer server_id;
//    private String name;
//    private String description;
//    private String full_image;
//    private Integer city;
//    private String adress;
//    private String lat;
//    private String lng;
//    private Integer ordering;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public Integer getServer_id() {
//        return server_id;
//    }
//
//    public void setServer_id(Integer server_id) {
//        this.server_id = server_id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getFull_image() {
//        return full_image;
//    }
//
//    public void setFull_image(String full_image) {
//        this.full_image = full_image;
//    }
//
//    public Integer getCity() {
//        return city;
//    }
//
//    public void setCity(Integer city) {
//        this.city = city;
//    }
//
//    public String getAdress() {
//        return adress;
//    }
//
//    public void setAdress(String adress) {
//        this.adress = adress;
//    }
//
//    public String getLat() {
//        return lat;
//    }
//
//    public void setLat(String lat) {
//        this.lat = lat;
//    }
//
//    public String getLng() {
//        return lng;
//    }
//
//    public void setLng(String lng) {
//        this.lng = lng;
//    }
//
//    public Integer getOrdering() {
//        return ordering;
//    }
//
//    public void setOrdering(Integer ordering) {
//        this.ordering = ordering;
//    }
//}
//
//
//
//public class ServiceResponse {
//    @SerializedName("server_id")
//    private Integer server_id;
//    @SerializedName("name")
//    private String name;
//    @SerializedName("description")
//    private String description;
//    @SerializedName("city")
//    private Integer city;
//    @SerializedName("adress")
//    private String adress;
//    @SerializedName("full_image")
//    private String full_image;
//    @SerializedName("lat")
//    private String lat;
//    @SerializedName("lng")
//    private String lng;
//    @SerializedName("types")
//    private List<TypesResponse> types;
//    @SerializedName("main_filters")
//    private List<FiltersResponse> main_filters;
//    @SerializedName("second_filters")
//    private List<FiltersResponse> second_filters;
//    @SerializedName("ordering")
//    private Integer ordering;
//
//
//    public Integer getServer_id() {
//        return server_id;
//    }
//
//    public void setServer_id(Integer server_id) {
//        this.server_id = server_id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Integer getCity() {
//        return city;
//    }
//
//    public void setCity(Integer city) {
//        this.city = city;
//    }
//
//    public String getAdress() {
//        return adress;
//    }
//
//    public void setAdress(String adress) {
//        this.adress = adress;
//    }
//
//    public String getFull_image() {
//        return full_image;
//    }
//
//    public void setFull_image(String full_image) {
//        this.full_image = full_image;
//    }
//
//    public String getLat() {
//        return lat;
//    }
//
//    public void setLat(String lat) {
//        this.lat = lat;
//    }
//
//    public String getLng() {
//        return lng;
//    }
//
//    public void setLng(String lng) {
//        this.lng = lng;
//    }
//
//    public List<TypesResponse> getType() {
//        return types;
//    }
//
//    public void setType(List<TypesResponse> type) {
//        this.types = types;
//    }
//
//    public List<FiltersResponse> getMain_filters() {
//        return main_filters;
//    }
//
//    public void setMain_filters(List<FiltersResponse> main_filters) {
//        this.main_filters = main_filters;
//    }
//
//    public List<FiltersResponse> getSecond_filters() {
//        return second_filters;
//    }
//
//    public void setSecond_filters(List<FiltersResponse> second_filters) {
//        this.second_filters = second_filters;
//    }
//
//    public Integer getOrdering() {
//        return ordering;
//    }
//
//    public void setOrdering(Integer ordering) {
//        this.ordering = ordering;
//    }
//}
//
//
//    public void onResponse(Call<ServicesFullResponse> call, Response<ServicesFullResponse> response) {
//        HashMap<String, String> paramService = new HashMap<>();
//
//        List<ServiceResponse> services = response.body().getServices();
//
//        for (DataLiveChampionshipItem.DataBean liga : DataLiveChampionshipItem.getData) {
//
//            for (TypesResponse tмамам : ligaюпуеВфеф) {
//
//                HashMap<String, String> paramService = new HashMap<>();
//
//                paramService.put("server_id", liga.getServer_id().toString()); // id лиги
//                paramService.put("name", service.getName()); //
//                paramService.put("description", service.getDescription());
//                paramService.put("full_image", service.getFull_image());
//                paramService.put("city", service.getCity().toString());
//                paramService.put("adress", service.getAdress());
//                paramService.put("lat", service.getLat());
//                paramService.put("lng", service.getLng());
//                paramService.put("ordering", service.getOrdering().toString());
//
//
//                paramType.put("server_id", tмамам.getServer_id().toString());
//                paramType.put("service_id", service.getServer_id().toString());
//                paramType.put("name", type.getName());
//
//                datasourceServices.createService(paramService);
//
//
//            }
//
//
//        }
//    }