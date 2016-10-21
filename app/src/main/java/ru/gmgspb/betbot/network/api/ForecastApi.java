package ru.gmgspb.betbot.network.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.gmgspb.betbot.network.entity.DataForecast;
import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;
import ru.gmgspb.betbot.network.entity.RobobetListModel;

public interface ForecastApi {
    @GET("feed_android_test.php?action=get_search_result")
    Call<DataForecast> getList();

    @GET("feed_android_test.php?action=get_sport_result")
    Call<RobobetListModel> getSportList();

    @GET("feed_android_test.php/?action=get_shedule_result&sport={id}&act=get_league")
    Call<DataLiveChampionship> getСhampionship (@Path("id") String id);

    @GET("feed_android_test.php/?action=get_shedule_result&sport={idSport}&act=get_matchi&league_id={idChampionship}")
    Call<DataLiveChampionshipList> getСhampionshipListGame
            (@Path("idSport") String id, @Path("idChampionship") String idChampionship);


}
