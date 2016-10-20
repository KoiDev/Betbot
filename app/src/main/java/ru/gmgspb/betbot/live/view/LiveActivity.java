package ru.gmgspb.betbot.live.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.BaseActivity;
import ru.gmgspb.betbot.live.adapter.LiveViewPagerAdapter;
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