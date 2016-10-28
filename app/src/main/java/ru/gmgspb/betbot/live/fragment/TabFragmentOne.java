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

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.gmgspb.betbot.BetBotApp;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.adapter.LiveGamesListAdapter;
import ru.gmgspb.betbot.network.api.ApiClient;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.RobobetListModel;


public class TabFragmentOne extends Fragment {

    private static final String ARG_EXAMPLE = "this_a_constant";
    private String example_data;

    @Inject
    protected ForecastApi api;

    private RecyclerView recyclerViewSports;
    private RecyclerView recyclerViewLeague;

    public TabFragmentOne(){

    }

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

        example_data = getArguments().getString(ARG_EXAMPLE);
        api = ApiClient.getClient().create(ForecastApi.class);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_all_games, container, false);

        recyclerViewSports = (RecyclerView) view.findViewById(R.id.section_allgames_header_rv_other);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerViewSports.setLayoutManager(manager);
        recyclerViewSports.setHasFixedSize(true);

        initRecyclerViewList(view);

        recyclerViewLeague = (RecyclerView) view.findViewById(R.id.section_allgames_header_rv_other);
        StaggeredGridLayoutManager managerLeague = new StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL);

        recyclerViewLeague.setLayoutManager(managerLeague);



        return view;
    }


    private void initRecyclerViewList(View view) {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_all_list_rv); //TODO ERROR
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        ForecastApi api = BetBotApp.getAppComponent().getForecastApi();
        final Call<RobobetListModel> robobetListModelCall = api.getSportList();

        robobetListModelCall.enqueue(new Callback<RobobetListModel>() {
            @Override
            public void onResponse(Call<RobobetListModel> call, Response<RobobetListModel> response) {
                RobobetListModel model = response.body();
                LiveGamesListAdapter adapter = new LiveGamesListAdapter(model.getData(), new LiveGamesListAdapter.LiveGamesListAdapterListener() {
                    @Override
                    public void liveGamesListViewOnClick(View v, int position) {

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

}
