package ru.gmgspb.betbot.live;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.gmgspb.betbot.live.adapter.LiveItemListAdapter;
import ru.gmgspb.betbot.live.fragment.TabFragmentTwo;
import ru.gmgspb.betbot.network.api.ApiClient;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;

public class GetListLeagueAndGames {

    private ViewPager viewPager;
    private int sport_id;
    public List<DataLiveChampionship.DataBean> championshipList;

    private List<DataLiveChampionshipList.DataBean.DataDetails> championshipListDetails = new ArrayList<>();
    private int item_sort;
    private String item_liga_pos;

    @Inject
    protected ForecastApi api;

    public void getListHeader(int sportId) {
        api = ApiClient.getClient().create(ForecastApi.class);
        Call<DataLiveChampionship> dataBeanCall = api.getСhampionship(sportId, "get_league");
        sport_id = sportId;
        dataBeanCall.enqueue(new Callback<DataLiveChampionship>() {
            @Override
            public void onResponse(Call<DataLiveChampionship> call, Response<DataLiveChampionship> response) {
                if (response.body().getTotalevent() > 0) {
                    championshipList = response.body().getData();

                    for (DataLiveChampionship.DataBean getLeague : championshipList) {
                        getListItem(getLeague.getLeague_id(), sport_id, getLeague.getLeague());
                    }
                }
            }

            @Override
            public void onFailure(Call<DataLiveChampionship> call, Throwable t) {
            }
        });

    }


    public void getListItem(String liguaId, int sportId, final String leagueName) {
        final Fragment twoFragment = (Fragment) viewPager.getAdapter().instantiateItem(viewPager, 1);
        api = ApiClient.getClient().create(ForecastApi.class);
        Call<DataLiveChampionshipList> matchi = api.getСhampionshipListGame(sportId, liguaId);
        item_sort = sportId;
        item_liga_pos = leagueName;
        matchi.enqueue(new Callback<DataLiveChampionshipList>() {
            @Override
            public void onResponse(Call<DataLiveChampionshipList> call, Response<DataLiveChampionshipList> response) {
                if (response.body().getTotalevent() > 0) {
                    for (DataLiveChampionshipList.DataBean detail : response.body().getData()) {
                        championshipListDetails = detail.getData();
                    }
                    ((TabFragmentTwo) twoFragment).sectionAdapter.addSection(new LiveItemListAdapter(
                            item_liga_pos, championshipListDetails, item_sort));
                    ((TabFragmentTwo) twoFragment).sectionAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<DataLiveChampionshipList> call, Throwable t) {
            }
        });
    }
}
