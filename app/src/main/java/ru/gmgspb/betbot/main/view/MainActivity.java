package ru.gmgspb.betbot.main.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.BaseActivity;
import ru.gmgspb.betbot.main.adapter.MainAdapter;
import ru.gmgspb.betbot.main.adapter.MainExpressAdapter;
import ru.gmgspb.betbot.network.entity.DataMain;

public class MainActivity extends BaseActivity {

    MainFilterDialog filterDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getMenuResId() {
        return R.menu.topforecast_menu_toolbar;
    }

    @Override
    protected void setupViews() {
        initRecyclerView();
        initRecyclerViewExpress();
    }

    private void initRecyclerViewExpress() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_rv_express);
        StaggeredGridLayoutManager managerExpress = new StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(managerExpress);
        MainExpressAdapter adapterExpress = new MainExpressAdapter(initData(), initCommand());
        recyclerView.setAdapter(adapterExpress);
    }

    private void initRecyclerView() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_rv);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        MainAdapter adapter = new MainAdapter(initData(), initCommand());
        recyclerView.setAdapter(adapter);

    }

    List<DataMain.DataBean> beanList;
    List<DataMain.DataBean.CommandBean> commandBeen;

    private List<DataMain.DataBean>  initData() {
        beanList = new ArrayList<>();

        beanList.add(new DataMain.DataBean(
                "19.09.16 16:32", "П1", "2.0", "60", "JackPot@ss.org",
                "12053.4", "+11.50", "0", "3", "Футбол.  Чемпионат MLS.",
                "Поставлю 0,5 на такой матч. Ставлю против правильной ставки поэтому в лайве маст хев сидеть"));
        beanList.add(new DataMain.DataBean(
                "19.09.16 16:32", "П1", "2.0", "60", "JackPot@ss.org",
                "12053.4", "-11.50", "0", "3", "Футбол.  Чемпионат MLS.",
                "Поставлю 0,5 на такой матч. Ставлю против правильной ставки поэтому в лайве маст хев сидеть"));
        beanList.add(new DataMain.DataBean(
                "19.09.16 16:32", "П1", "2.0", "60", "JackPot@ss.org",
                "12053.4", "-11.50", "0", "3", "Футбол.  Чемпионат MLS.",
                "Поставлю 0,5 на такой матч. Ставлю против правильной ставки поэтому в лайве маст хев сидеть"));
        beanList.add(new DataMain.DataBean(
                "19.09.16 16:32", "П1", "2.0", "60", "JackPot@ss.org",
                "12053.4", "-11.50", "0", "3", "Футбол.  Чемпионат MLS.",
                "Поставлю 0,5 на такой матч. Ставлю против правильной ставки поэтому в лайве маст хев сидеть"));

        return beanList;
    }

    private List<DataMain.DataBean.CommandBean> initCommand(){
        commandBeen = new ArrayList<>();

        commandBeen.add(new DataMain.DataBean.CommandBean(
                "Германия", "Италия",
                R.drawable.de_flag, R.drawable.it_flag));
        commandBeen.add(new DataMain.DataBean.CommandBean(
                "Германия", "Италия",
                R.drawable.de_flag, R.drawable.it_flag));
        commandBeen.add(new DataMain.DataBean.CommandBean(
                "Германия", "Италия",
                R.drawable.de_flag, R.drawable.it_flag));
        commandBeen.add(new DataMain.DataBean.CommandBean(
                "Германия", "Италия",
                R.drawable.de_flag, R.drawable.it_flag));

        return commandBeen;
    }

    public void showFilter(){
        filterDialog = new MainFilterDialog(MainActivity.this);
        Window window = filterDialog.getWindow();
        WindowManager.LayoutParams paramsFiterWindow = window.getAttributes();
        paramsFiterWindow.gravity = Gravity.RIGHT;
        paramsFiterWindow.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(paramsFiterWindow);
        filterDialog.show();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.top_forecast_filter_menu:
                showFilter();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
