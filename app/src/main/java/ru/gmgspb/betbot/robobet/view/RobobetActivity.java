package ru.gmgspb.betbot.robobet.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import ru.gmgspb.betbot.forecast.view.ForecastsSearchActivity;
import ru.gmgspb.betbot.robobet.adapter.RobobetListAdapter;
import ru.gmgspb.betbot.robobet.adapter.RobobetListGetAdapter;
import ru.gmgspb.betbot.network.entity.RobobetGetModel;
import ru.gmgspb.betbot.network.entity.RobobetListModel;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.forecasttop.view.TopForecast;

public class RobobetActivity extends AppCompatActivity {

    private DrawerLayout dLayout;
    private List<RobobetListModel> list;
    private List<RobobetGetModel> listGet;

    RecyclerView recyclerView, recyclerViewGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robobet);
        setToolBar();

        initRecyclerViewList();
        initRecyclerViewListGet();

    }

    private void initRecyclerViewListGet() {
        recyclerViewGet = (RecyclerView) findViewById(R.id.robobet_list_get_cv);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewGet.setLayoutManager(layoutManager);
        recyclerViewGet.setHasFixedSize(true);
        RobobetListGetAdapter adapter = new RobobetListGetAdapter(initRvListGet());
        recyclerViewGet.setAdapter(adapter);
    }

    //create temp list fo recyclerViewGet
    private List<RobobetGetModel> initRvListGet() {
        listGet = new ArrayList<>();
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));
        listGet.add(new RobobetGetModel("Мордовия", "Кр. Советов", "32%", "#f5f5f5", "41%", "#e8f5e9", "2.10" , "34.00", "1X", "6", "0"));

        return listGet;
    }


    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_default);
        actionBar.setDisplayHomeAsUpEnabled(true);

        setNavigationDrawer();
    }



    private void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.activity_robobet);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_robobet);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.robobet){
                    dLayout.closeDrawers();
                } else if (item.getItemId() == R.id.forecasts_search) {
                    Intent intent = new Intent(RobobetActivity.this, ForecastsSearchActivity.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.top_rates) {
                    Intent intent = new Intent(RobobetActivity.this, TopForecast.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.robobet_menu_toolbar, menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.robobet_menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.robobet_calendar:
                break;
            case android.R.id.home: {
                dLayout.openDrawer(GravityCompat.START);
                return true;}
        }
        return true;
    }

    private void initRecyclerViewList() {
        recyclerView = (RecyclerView) findViewById(R.id.robobet_list_rv);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
//        RobobetListAdapter adapter = new RobobetListAdapter(intiDate());
//        recyclerView.setAdapter(adapter);
    }

//    private List<RobobetListModel> intiDate() {
//        list = new ArrayList<>();
//        list.add(new RobobetListModel(R.drawable.all, "Все"));
//        list.add(new RobobetListModel(R.drawable.football, "Футбол"));
//        list.add(new RobobetListModel(R.drawable.tennis, "Тенис"));
//        list.add(new RobobetListModel(R.drawable.hockey, "Хоккей"));
//        list.add(new RobobetListModel(R.drawable.backetball, "Баскетбол"));
//        list.add(new RobobetListModel(R.drawable.volleyball, "Волейбол"));
//        list.add(new RobobetListModel(R.drawable.am_footbool, "Америк.футбол"));
//        list.add(new RobobetListModel(R.drawable.baseball, "Бейсбол"));
//        list.add(new RobobetListModel(R.drawable.rugby, "Регби"));
//        list.add(new RobobetListModel(R.drawable.badminton, "Бадбинтон"));
//        list.add(new RobobetListModel(R.drawable.waterpolo, "Водное поло"));
//        list.add(new RobobetListModel(R.drawable.futsal, "Футзал"));
//        list.add(new RobobetListModel(R.drawable.darts, "Дартс"));
//        list.add(new RobobetListModel(R.drawable.table_tennis, "Настрол.тенис"));
//        list.add(new RobobetListModel(R.drawable.chess, "Шахматы"));
//        list.add(new RobobetListModel(R.drawable.snooker, "Снукер"));
//        list.add(new RobobetListModel(R.drawable.hockey_grass, "Хоккей на траве"));
//        list.add(new RobobetListModel(R.drawable.hockey_ball, "Теннис с мячом"));
//        list.add(new RobobetListModel(R.drawable.skiing, "Лыжи"));
//        list.add(new RobobetListModel(R.drawable.cybersport, "Киберспоррт"));
//        list.add(new RobobetListModel(R.drawable.beach_soccer, "Пляжний футбол"));
//        list.add(new RobobetListModel(R.drawable.handball, "Нагдбол"));
//        list.add(new RobobetListModel(R.drawable.biathlon, "Биатлон"));
//        return list;
//    }

    public void showMoreInfo (View view) {
        RelativeLayout robobetInfo = (RelativeLayout) findViewById(R.id.robobet_rl_info_all);

        if (robobetInfo.getVisibility() == View.VISIBLE){
            robobetInfo.setVisibility(View.GONE);
        } else {
            robobetInfo.setVisibility(View.VISIBLE);
        }
    }

}
