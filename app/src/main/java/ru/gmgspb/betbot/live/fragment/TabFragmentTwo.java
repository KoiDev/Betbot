package ru.gmgspb.betbot.live.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.adapter.LiveGamesListAdapter;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.RobobetListModel;
import ru.gmgspb.betbot.network.repository.ForecastService;

public class TabFragmentTwo extends Fragment{

    private static final String ARG_EXAMPLE = "this_a_constant";
    private String example_data;

    public TabFragmentTwo(){

    }

    public static TabFragmentTwo newInstance(String example_argument){
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

        return view;
    }

    private void initRecyclerViewList(View view) {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_live_rv); //TODO ERROR
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        ForecastApi api = ForecastService.getInstance(view.getContext()).getApi();
        final Call<RobobetListModel> robobetListModelCall = api.getSportList();

        robobetListModelCall.enqueue(new Callback<RobobetListModel>() {
            @Override
            public void onResponse(Call<RobobetListModel> call, Response<RobobetListModel> response) {
                final RobobetListModel model = response.body();
                LiveGamesListAdapter adapter = new LiveGamesListAdapter(model.getData(), new LiveGamesListAdapter.LiveGamesListAdapterListener() {
                    @Override
                    public void liveGamesListViewOnClick(View v, int position) {
                        RobobetListModel.DataBean bean = (RobobetListModel.DataBean) model.getData();
                        initRecyclerViewListGames(bean.getId());
                    }
                });
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RobobetListModel> call, Throwable t) {
                Log.e("Tag", t.getMessage());
            }
        });

    }

    private SectionedRecyclerViewAdapter sectionedAdapter;
    private void initRecyclerViewListGames(int id){
        sectionedAdapter = new SectionedRecyclerViewAdapter();

        sectionedAdapter.addSection()
    }
}
