package ru.gmgspb.betbot.live.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.gmgspb.betbot.BetBotApp;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.GetListLeagueAndGames;
import ru.gmgspb.betbot.live.adapter.LiveAllGamesHeaderOtherAdapter;
import ru.gmgspb.betbot.live.adapter.LiveGamesListAdapter;
import ru.gmgspb.betbot.live.view.LiveActivity;
import ru.gmgspb.betbot.network.api.ApiClient;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;
import ru.gmgspb.betbot.network.entity.RobobetListModel;

public class TabFragmentOne extends Fragment {

    private static final String ARG_EXAMPLE = "this_a_constant";
//    private String example_data;
    private RecyclerView recyclerViewSports;
    public RecyclerView recyclerViewLeague;
    private GetListLeagueAndGames gamesList;

    @Inject
    protected ForecastApi api;

    public static TabFragmentOne newInstance(String example_argument){
        TabFragmentOne tabFragmentOne = new TabFragmentOne();
        Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argument);
        tabFragmentOne.setArguments(args);
        return tabFragmentOne;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        BetBotApp.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        api = ApiClient.getClient().create(ForecastApi.class);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_all_games, container, false);

        recyclerViewSports = (RecyclerView) view.findViewById(R.id.fragment_all_header_rv);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerViewSports.setLayoutManager(manager);
        recyclerViewSports.setHasFixedSize(true);

        initRecyclerViewList();


//        gamesList = new GetListLeagueAndGames();
//        gamesList.getListHeader(1);
        recyclerViewLeague = (RecyclerView) view.findViewById(R.id.section_allgames_header_rv_other);
        StaggeredGridLayoutManager managerHeader = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewLeague.setLayoutManager(managerHeader);
        initRecyclerHeaderList(1);
//        LiveAllGamesHeaderOtherAdapter otherAdapter = new LiveAllGamesHeaderOtherAdapter(
//                gamesList.championshipList);
//
//        recyclerViewLeague.setAdapter(otherAdapter);

        return view;
    }

    List<DataLiveChampionship.DataBean> championshipList;
    private void initRecyclerHeaderList(int sportId) {
        api = ApiClient.getClient().create(ForecastApi.class);
        championshipList = new ArrayList<>();
        Call<DataLiveChampionship> dataBeanCall = api.getСhampionship(sportId, "get_league");
//        sport_id = sportId;
        dataBeanCall.enqueue(new Callback<DataLiveChampionship>() {
            @Override
            public void onResponse(Call<DataLiveChampionship> call, Response<DataLiveChampionship> response) {
                if (response.body().getTotalevent() > 0) {
                    championshipList = response.body().getData();
                    LiveAllGamesHeaderOtherAdapter otherAdapter =
                            new LiveAllGamesHeaderOtherAdapter(championshipList);
                    recyclerViewLeague.setAdapter(otherAdapter);

//                    for (DataLiveChampionship.DataBean getLeague : championshipList) {
//                        getListItem(getLeague.getLeague_id(), sport_id, getLeague.getLeague());
//                    }
                }
            }

            @Override
            public void onFailure(Call<DataLiveChampionship> call, Throwable t) {
            }
        });
    }

    private List<RobobetListModel.DataBean> robobetList = new ArrayList<>();
    private LiveGamesListAdapter adapter;

    private void initRecyclerViewList() {
        gamesList = new GetListLeagueAndGames();

        Call<RobobetListModel> robobetListModelCall = api.getSportList();

        robobetListModelCall.enqueue(new Callback<RobobetListModel>() {
            @Override
            public void onResponse(Call<RobobetListModel> call, Response<RobobetListModel> response) {
                robobetList = response.body().getData();
                adapter = new LiveGamesListAdapter(robobetList, new LiveGamesListAdapter.LiveGamesListAdapterListener() {
                    @Override
                    public void liveGamesListViewOnClick(View v, int position) {
                        RobobetListModel.DataBean bean = robobetList.get(position);
                        gamesList.getListHeader(bean.getId());
                    }
                });
                recyclerViewSports.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<RobobetListModel> call, Throwable t) {
            }
        });
    }

}
