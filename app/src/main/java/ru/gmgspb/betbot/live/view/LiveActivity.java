package ru.gmgspb.betbot.live.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.gmgspb.betbot.BetBotApp;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.BaseActivity;
import ru.gmgspb.betbot.live.adapter.LiveGamesListAdapter;
import ru.gmgspb.betbot.live.adapter.LiveItemListAdapter;
import ru.gmgspb.betbot.live.adapter.LiveViewPagerAdapter;
import ru.gmgspb.betbot.live.fragment.TabFragmentOne;
import ru.gmgspb.betbot.live.fragment.TabFragmentThree;
import ru.gmgspb.betbot.live.fragment.TabFragmentTwo;
import ru.gmgspb.betbot.live.sections.helpersDB.ServicesDataSource;
import ru.gmgspb.betbot.network.api.ApiClient;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;
import ru.gmgspb.betbot.network.entity.RobobetListModel;

public class LiveActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] tabIcons = {R.drawable.all_games_default,
            R.drawable.live_default,
            R.drawable.my_games_default};

    @Inject
    protected ForecastApi api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BetBotApp.getAppComponent().inject(this);   //binding Dagger2
        super.onCreate(savedInstanceState);
        api = ApiClient.getClient().create(ForecastApi.class);  //injection Dagger2

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_live;
    }

    @Override
    protected void setupViews() {
        viewPager = (ViewPager) findViewById(R.id.main_viewpaget);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.main_tabs_start);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private int sport_id;
    public List<DataLiveChampionship.DataBean> championshipList;

    public void getListHeader(int sportId) {

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

    private List<DataLiveChampionshipList.DataBean.DataDetails> championshipListDetails = new ArrayList<>();
    private int item_sort;
    private String item_liga_pos;


    public void getListItem(String liguaId, int sportId, final String liguaName) {
        final Fragment twoFragment = (Fragment) viewPager.getAdapter().instantiateItem(viewPager, 1);

        Call<DataLiveChampionshipList> matchi = api.getСhampionshipListGame(sportId, liguaId);
        item_sort = sportId;
        item_liga_pos = liguaName;
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

//                    ((TabFragmentOne) oneFragment).sectionAdapter.addSection(new LiveItemListAdapter(
//                            item_liga_pos, championshipListDetails, item_sort));
//                    ((TabFragmentOne) oneFragment).sectionAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<DataLiveChampionshipList> call, Throwable t) {
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        LiveViewPagerAdapter adapter = new LiveViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(TabFragmentOne.newInstance("this is fragment 1"), "Все игры");
        adapter.addFragment(TabFragmentTwo.newInstance("this is fragment 2"), "LIVE");
        adapter.addFragment(TabFragmentThree.newInstance("this is fragment 3"), "Мои игры");
        viewPager.setAdapter(adapter);
    }

    @Override
    protected int getMenuResId() {
        return R.menu.forecasts_menu_toolbar;
    }


}