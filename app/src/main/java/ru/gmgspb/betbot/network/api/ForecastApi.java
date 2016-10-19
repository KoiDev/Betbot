package ru.gmgspb.betbot.network.api;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.gmgspb.betbot.network.entity.DataForecast;

/**
 * Created by User on 026 26.09.16.
 */

public interface ForecastApi {
    @GET("feed_android_test.php?action=get_search_result")
    Call<DataForecast> getList();
}
