package ru.gmgspb.betbot.live.fragment;

import android.os.Bundle;
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
import ru.gmgspb.betbot.live.adapter.LiveGamesListAdapter;
import ru.gmgspb.betbot.live.view.LiveActivity;
import ru.gmgspb.betbot.network.api.ApiClient;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;
import ru.gmgspb.betbot.network.entity.RobobetListModel;

public class TabFragmentTwo extends Fragment {
    private static final String ARG_EXAMPLE = "this_a_constant";
    private String example_data;
    private List<RobobetListModel.DataBean> robobetList = new ArrayList<>();
    public List<DataLiveChampionship.DataBean> championshipList = new ArrayList<>();
    private RecyclerView recyclerView;
    public RecyclerView recyclerViewSports;
    private List<DataLiveChampionshipList.DataBean.DataDetails> championshipListDetails = new ArrayList<>();
    public SectionedRecyclerViewAdapter sectionAdapter;
    private LiveGamesListAdapter adapter;
    private int sport_id;
    private String item_liga;
    private int item_sort;
    private int item_liga_pos;

    @Inject
    protected ForecastApi api;


    public static TabFragmentTwo newInstance(String example_argument) {
        TabFragmentTwo oneFragment = new TabFragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argument);
        oneFragment.setArguments(args);
        return oneFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        BetBotApp.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        example_data = getArguments().getString(ARG_EXAMPLE);
        api = ApiClient.getClient().create(ForecastApi.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_tablive, container, false);

        recyclerViewSports = (RecyclerView) view.findViewById(R.id.fragment_live_rv);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerViewSports.setLayoutManager(manager);
        recyclerViewSports.setHasFixedSize(true);


        initRecyclerViewList();

        recyclerView = (RecyclerView) view.findViewById(R.id.live_tablelive_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        sectionAdapter = new SectionedRecyclerViewAdapter();


        ((LiveActivity) getActivity()).getListHeader(1);
//        addSectionToRecycler(); //TODO initialize section of RecyclerView
//        List<DataLiveChampionship.DataBean> championshipListTemp = LiveRecyclerServices.getListHeader(1);


        recyclerView.setAdapter(sectionAdapter);

        return view;
    }


    private void initRecyclerViewList() {
        Call<RobobetListModel> robobetListModelCall = api.getSportList();

        robobetListModelCall.enqueue(new Callback<RobobetListModel>() {
            @Override
            public void onResponse(Call<RobobetListModel> call, Response<RobobetListModel> response) {
                robobetList = response.body().getData();
                adapter = new LiveGamesListAdapter(robobetList, new LiveGamesListAdapter.LiveGamesListAdapterListener() {
                    @Override
                    public void liveGamesListViewOnClick(View v, int position) {
                        RobobetListModel.DataBean bean = robobetList.get(position);
                        sectionAdapter.removeAllSections();
                        sectionAdapter.notifyDataSetChanged();
                        ((LiveActivity) getActivity()).getListHeader(bean.getId());
                    }
                });
                recyclerViewSports.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<RobobetListModel> call, Throwable t) {
            }
        });
    }

 /*   private void getListHeader(int sportId) {

        Call<DataLiveChampionship> dataBeanCall = api.getСhampionship(sportId, "get_league");
        sport_id = sportId;
        dataBeanCall.enqueue(new Callback<DataLiveChampionship>() {
            @Override
            public void onResponse(Call<DataLiveChampionship> call, Response<DataLiveChampionship> response) {
                if (response.body().getTotalevent() > 0) {
                    championshipList = response.body().getData();
                    int i = 0;
                    for (DataLiveChampionship.DataBean getLigua : championshipList) {
                        getListItem(getLigua.getLeague_id(), sport_id, i);
                        i++;
                    }
                }
            }
            @Override
            public void onFailure(Call<DataLiveChampionship> call, Throwable t) {
            }
        });
    }

    private void getListItem(String liguaId, int sportId, int liguaPos) {

        Call<DataLiveChampionshipList> matchi = api.getСhampionshipListGame(sportId, liguaId);
        item_liga = liguaId;
        item_sort = sportId;
        item_liga_pos = liguaPos;
        matchi.enqueue(new Callback<DataLiveChampionshipList>() {
            @Override
            public void onResponse(Call<DataLiveChampionshipList> call, Response<DataLiveChampionshipList> response) {
                if (response.body().getTotalevent() > 0) {
                    for (DataLiveChampionshipList.DataBean detail : response.body().getData()) {
                        championshipListDetails = detail.getData();
                    }
//                    DataLiveChampionship.DataBean bean = championshipList.get(item_liga_pos);
//                    sectionAdapter.addSection(new LiveItemListAdapter(
//                            bean.getLeague(), championshipListDetails, item_sort));
//
//                    sectionAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<DataLiveChampionshipList> call, Throwable t) {
            }
        });
    }

    private void addSectionToRecycler(String league, List<DataLiveChampionshipList.DataBean.DataDetails> listData,
                                      int sportId){

        DataLiveChampionship.DataBean bean = championshipList.get(item_liga_pos);

        sectionAdapter.addSection(new LiveItemListAdapter(bean.getLeague(), championshipListDetails, sportId));
        sectionAdapter.notifyDataSetChanged();
    }*/

}