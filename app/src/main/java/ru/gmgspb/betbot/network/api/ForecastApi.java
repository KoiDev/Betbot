package ru.gmgspb.betbot.network.api;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.gmgspb.betbot.network.entity.DataForecast;
import ru.gmgspb.betbot.network.entity.RobobetListModel;

public interface ForecastApi {
    @GET("feed_android_test.php?action=get_search_result")
    Call<DataForecast> getList();

    @GET("feed_android_test.php?action=get_sport_result")
    Call<RobobetListModel> getSportList();
}
