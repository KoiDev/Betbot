package ru.gmgspb.betbot.network.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.gmgspb.betbot.network.entity.GetDescriptionForecastModel;

public interface GetDescriptionForecastApi {
    @GET("feed_android.php?action=get_description")
    Call<GetDescriptionForecastModel> getList (@Query("id") String id);
}
