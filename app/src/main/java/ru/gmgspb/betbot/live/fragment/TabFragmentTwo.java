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

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.adapter.LiveGamesListAdapter;
import ru.gmgspb.betbot.live.adapter.LiveItemListAdapter;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
import ru.gmgspb.betbot.network.entity.RobobetListModel;
import ru.gmgspb.betbot.network.repository.ForecastService;

public class TabFragmentTwo extends Fragment {

    private static final String ARG_EXAMPLE = "this_a_constant";
    private String example_data;
    private List<RobobetListModel.DataBean> robobetList = new ArrayList<>();
    private List<DataLiveChampionship.DataBean> championshipList = new ArrayList<>();
    private int id;
    private List<String> contacts = new ArrayList<>();
    private RecyclerView recyclerView;
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
        initData(1);
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
                        initData(id);
                    }
                });
                getListHeade(view, id);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RobobetListModel> call, Throwable t) {
                Log.e("Tag", t.getMessage());
            }
        });



    }

    private void initData(int id) {
        sectionAdapter.removeAllSections();
//        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
//            contacts = getContactsWithLetter(alphabet);
//            sectionAdapter.addSection(new LiveItemListAdapter(String.valueOf(alphabet), contacts, id));
//        }

        for (DataLiveChampionship.DataBean model : championshipList){

            sectionAdapter.addSection(new LiveItemListAdapter(model.getLeague(), null, id));
        }
        recyclerView.setAdapter(sectionAdapter);
    }

    private void getListItem(View view, String id){

    }

    private void getListHeade(View view, final int id){
        ForecastApi api = ForecastService.getInstance(view.getContext()).getApi();
        Call<DataLiveChampionship> dataBeanCall = api.getСhampionship(id);

        dataBeanCall.enqueue(new Callback<DataLiveChampionship>() {
            @Override
            public void onResponse(Call<DataLiveChampionship> call, Response<DataLiveChampionship> response) {
                championshipList = response.body().getData();
            }

            @Override
            public void onFailure(Call<DataLiveChampionship> call, Throwable t) {

            }
        });
    }


    private List<String> getContactsWithLetter(char letter) {
        List<String> contacts = new ArrayList<>();

        for (String contact : getResources().getStringArray(R.array.names)) {
            if (contact.charAt(0) == letter) {
                contacts.add(contact);
            }
        }
        return contacts;
    }

}
