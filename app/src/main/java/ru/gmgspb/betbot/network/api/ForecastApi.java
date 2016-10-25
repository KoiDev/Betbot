package ru.gmgspb.betbot.network.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.gmgspb.betbot.network.entity.DataForecast;
import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;
import ru.gmgspb.betbot.network.entity.GetDescriptionForecastModel;
import ru.gmgspb.betbot.network.entity.RobobetListModel;

public interface ForecastApi {

    @GET("feed_android_test.php?action=get_search_result")
    Call<DataForecast> getListForecast();

    /* Get description for forecast, first screen in menu */
    @GET("feed_android.php?action=get_description")
    Call<GetDescriptionForecastModel> getListDescriptionForecast (@Query("id") String id);

    @GET("feed_android_test.php?action=get_sport_result")
    Call<RobobetListModel> getSportList();

    //http://vprognoze.ru/api/feed_android_test.php/?action=get_shedule_result&sport=ИД спорта&act=get_league
    @GET("feed_android_test.php/?action=get_shedule_result")
    Call<DataLiveChampionship> getСhampionship (
            @Query("sport") int id,
            @Query("act") String s);

//http://vprognoze.ru/api/feed_android_test.php/?action=get_shedule_result&sport=1&act=get_matchi&league_id=4645543
    @GET("feed_android_test.php/?action=get_shedule_result&act=get_matchi")
    Call<DataLiveChampionshipList> getСhampionshipListGame(
            @Query("sport") int id,
            //@Query("act") String s,
            @Query("league_id") String idChampionship);
}
