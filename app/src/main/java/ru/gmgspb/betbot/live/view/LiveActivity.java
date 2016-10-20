package ru.gmgspb.betbot.live.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.BaseActivity;
import ru.gmgspb.betbot.live.adapter.ViewPagerAdapter;
import ru.gmgspb.betbot.live.fragment.TabFragmentOne;
import ru.gmgspb.betbot.live.fragment.TabFragmentThree;
import ru.gmgspb.betbot.live.fragment.TabFragmentTwo;

public class LiveActivity extends BaseActivity{

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] tabIcons = {R.drawable.all_games_default,
                            R.drawable.live_default,
                            R.drawable.my_games_default};

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

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(TabFragmentOne.newInstance("this is fragment 1"), "Все игры");
        adapter.addFragment(TabFragmentTwo.newInstance("this is fragment 2"), "LIVE");
        adapter.addFragment(TabFragmentThree.newInstance("this is fragment 3"), "Мои игры");
        viewPager.setAdapter(adapter);
    }

    @Override
    protected int getMenuResId() {
        return R.menu.forecasts_menu_toolbar;
    }



//    RecyclerView recyclerView;
//    private void initRecyclerViewList() {
//        recyclerView = (RecyclerView) findViewById(R.id.live_list_rv);
//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setHasFixedSize(true);
//        LiveGamesListAdapter adapter = new LiveGamesListAdapter(intiDate());
//        recyclerView.setAdapter(adapter);
//    }
//
//    List<RobobetListModel> list;
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
}