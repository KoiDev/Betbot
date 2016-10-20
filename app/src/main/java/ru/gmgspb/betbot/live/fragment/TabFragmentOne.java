package ru.gmgspb.betbot.live.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.adapter.LiveGamesListAdapter;
import ru.gmgspb.betbot.network.entity.RobobetListModel;


public class TabFragmentOne extends Fragment{

    private static final String ARG_EXAMPLE = "this_a_constant";
    private String example_data;

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
        super.onCreate(savedInstanceState);
        example_data = getArguments().getString(ARG_EXAMPLE);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_all_games, container, false);
        initRecyclerViewList(view);
        return view;
    }


    private void initRecyclerViewList(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_all_list_rv); //TODO ERROR
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        LiveGamesListAdapter adapter = new LiveGamesListAdapter(intiDate());
        recyclerView.setAdapter(adapter);
    }

    List<RobobetListModel> list;
    private List<RobobetListModel> intiDate() {
        list = new ArrayList<>();
        list.add(new RobobetListModel(R.drawable.all, "Все"));
        list.add(new RobobetListModel(R.drawable.football, "Футбол"));
        list.add(new RobobetListModel(R.drawable.tennis, "Тенис"));
        list.add(new RobobetListModel(R.drawable.hockey, "Хоккей"));
        list.add(new RobobetListModel(R.drawable.backetball, "Баскетбол"));
        list.add(new RobobetListModel(R.drawable.volleyball, "Волейбол"));
        list.add(new RobobetListModel(R.drawable.am_footbool, "Америк.футбол"));
        list.add(new RobobetListModel(R.drawable.baseball, "Бейсбол"));
        list.add(new RobobetListModel(R.drawable.rugby, "Регби"));
        list.add(new RobobetListModel(R.drawable.badminton, "Бадбинтон"));
        list.add(new RobobetListModel(R.drawable.waterpolo, "Водное поло"));
        list.add(new RobobetListModel(R.drawable.futsal, "Футзал"));
        list.add(new RobobetListModel(R.drawable.darts, "Дартс"));
        list.add(new RobobetListModel(R.drawable.table_tennis, "Настрол.тенис"));
        list.add(new RobobetListModel(R.drawable.chess, "Шахматы"));
        list.add(new RobobetListModel(R.drawable.snooker, "Снукер"));
        list.add(new RobobetListModel(R.drawable.hockey_grass, "Хоккей на траве"));
        list.add(new RobobetListModel(R.drawable.hockey_ball, "Теннис с мячом"));
        list.add(new RobobetListModel(R.drawable.skiing, "Лыжи"));
        list.add(new RobobetListModel(R.drawable.cybersport, "Киберспоррт"));
        list.add(new RobobetListModel(R.drawable.beach_soccer, "Пляжний футбол"));
        list.add(new RobobetListModel(R.drawable.handball, "Нагдбол"));
        list.add(new RobobetListModel(R.drawable.biathlon, "Биатлон"));
        return list;
    }
}
