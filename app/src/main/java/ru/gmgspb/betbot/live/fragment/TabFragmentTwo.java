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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.adapter.LiveGamesListAdapter;
import ru.gmgspb.betbot.live.adapter.LiveItemListAdapter;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;
import ru.gmgspb.betbot.network.entity.RobobetListModel;
import ru.gmgspb.betbot.network.repository.ForecastService;

public class TabFragmentTwo extends Fragment {

    private static final String ARG_EXAMPLE = "this_a_constant";
    private String example_data;
    private List<RobobetListModel.DataBean> robobetList = new ArrayList<>();
    private List<DataLiveChampionship.DataBean> championshipList = new ArrayList<>();
    private int id;
    private RecyclerView recyclerView;
    private List<DataLiveChampionshipList.DataBean.DataDetails> championshipListDetails = new ArrayList<>();
    public static SectionedRecyclerViewAdapter sectionAdapter;

    public TabFragmentTwo() {

    }

    public static TabFragmentTwo newInstance(String example_argument) {
        TabFragmentTwo oneFragment = new TabFragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argument);
        oneFragment.setArguments(args);
        return oneFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        example_data = getArguments().getString(ARG_EXAMPLE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_tablive, container, false);
        initRecyclerViewList(view);

        sectionAdapter = new SectionedRecyclerViewAdapter();
        recyclerView = (RecyclerView) view.findViewById(R.id.live_tablelive_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getListHeade(view, 1);
        recyclerView.setAdapter(sectionAdapter);
        return view;
    }

    private void initRecyclerViewList(final View view) {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_live_rv);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        ForecastApi api = ForecastService.getInstance(view.getContext()).getApi();
        final Call<RobobetListModel> robobetListModelCall = api.getSportList();

        robobetListModelCall.enqueue(new Callback<RobobetListModel>() {
            @Override
            public void onResponse(Call<RobobetListModel> call, Response<RobobetListModel> response) {
                robobetList = response.body().getData();
                LiveGamesListAdapter adapter = new LiveGamesListAdapter(robobetList, new LiveGamesListAdapter.LiveGamesListAdapterListener() {
                    @Override
                    public void liveGamesListViewOnClick(View v, int position) {
                        RobobetListModel.DataBean bean = robobetList.get(position);
                        id = bean.getId();
                        getListHeade(view, id);                    }
                });
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RobobetListModel> call, Throwable t) {
                Log.e("Tag", t.getMessage());
            }
        });

    }
//    private void initData(View view, int id) {
//        sectionAdapter.removeAllSections();
//        getListHeade(view, id);
//        for (DataLiveChampionship.DataBean model : championshipList){
//            getListItem(view, model.getLeague_id(), id);
//            int i = 0;
//            for (DataLiveChampionshipList.DataBean details :  championshipListDetails)
//                sectionAdapter.addSection(new LiveItemListAdapter(
//                        model.getLeague_id(), details.getData(), id));
//        }
//        recyclerView.setAdapter(sectionAdapter);

        /*sectionAdapter.removeAllSections();
        getListHeade(view, id);
        for (DataLiveChampionship.DataBean model : championshipList){
            sectionAdapter.addSection(new LiveItemListAdapter(
                    model.getLeague(), championshipListDetails, id));
        }
        recyclerView.setAdapter(sectionAdapter);*/
//    }



    private List<String> liguaId = new ArrayList<>();
    private void getListHeade(final View view, final int id){
        liguaId.clear();
        ForecastApi api = ForecastService.getInstance(view.getContext()).getApi();
        Call<DataLiveChampionship> dataBeanCall = api.getСhampionship(id, "get_league");

        dataBeanCall.enqueue(new Callback<DataLiveChampionship>() {
            @Override
            public void onResponse(Call<DataLiveChampionship> call, Response<DataLiveChampionship> response) {
                /*championshipList = response.body().getData();
                for (DataLiveChampionship.DataBean getLigua : championshipList){
                    liguaId.add(getLigua.getLeague_id());
                }

                Log.d("TAG: ", "Connect Header OK");*/
                championshipList = response.body().getData();
                for (DataLiveChampionship.DataBean getLigua : championshipList){
                    liguaId.add(getLigua.getLeague_id());
                    championshipListDetails = getListItem(view, getLigua.getLeague_id(), id);
                    sectionAdapter.addSection(new LiveItemListAdapter(
                            getLigua.getLeague(), championshipListDetails, id));
                }
                sectionAdapter.notifyDataSetChanged();
                //recyclerView.setAdapter(sectionAdapter);
                /*for (String idString : liguaId)
                    getListItem(view, idString, id);*/
            }
            @Override
            public void onFailure(Call<DataLiveChampionship> call, Throwable t) {
                Log.d("TAG: ", "Connect Header NOT");
            }
        });
    }


    private List<DataLiveChampionshipList.DataBean.DataDetails> championshipListDetailsTemp;

    private List<DataLiveChampionshipList.DataBean.DataDetails> getListItem(View view, String liguaId, int sportId){
        championshipListDetailsTemp = new ArrayList<>();
        ForecastApi api = ForecastService.getInstance(view.getContext()).getApi();
        Call<DataLiveChampionshipList> matchi = api.getСhampionshipListGame(sportId, liguaId);
        matchi.enqueue(new Callback<DataLiveChampionshipList>() {                                                           //TODO Error
            @Override
            public void onResponse(Call<DataLiveChampionshipList> call, Response<DataLiveChampionshipList> response) {
                for (DataLiveChampionshipList.DataBean detail : response.body().getData()) {
                    championshipListDetailsTemp = detail.getData();
                }
                Log.e("TAG: ", "Connect Item");
            }

            @Override
            public void onFailure(Call<DataLiveChampionshipList> call, Throwable t) {
                Log.e("TAG: ", "Connect Item NOT");
            }
        });
        return championshipListDetailsTemp;

    }


}
