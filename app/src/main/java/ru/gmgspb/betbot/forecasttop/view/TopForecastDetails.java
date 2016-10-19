package ru.gmgspb.betbot.forecasttop.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.BaseActivity;
import ru.gmgspb.betbot.network.entity.DataTopForesastDetails;
import ru.gmgspb.betbot.forecasttop.adapter.TopForecastDetailsAdapter;

public class TopForecastDetails extends BaseActivity {


    @BindView(R.id.top_forecast_details_more_btn)
    TextView btnMore;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_forecast_details;
    }

    @Override
    protected void setupViews() {
        initRecyclerPrognosticator();

    }

    private void initRecyclerPrognosticator() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_top_forecast_details_rv);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        TopForecastDetailsAdapter adapter = new TopForecastDetailsAdapter(initData());
        recyclerView.setAdapter(adapter);
    }

    private List<DataTopForesastDetails.DataBean.DataUsersBean> list;
    private List<DataTopForesastDetails.DataBean.DataUsersBean> initData() {
        list = new ArrayList<>();
        list.add(new DataTopForesastDetails.DataBean.DataUsersBean
                ("NOSTARDAMUS SPORT", "Тотал по геймам больше(22.5)", "31%", "+118.9%"));
        list.add(new DataTopForesastDetails.DataBean.DataUsersBean
                ("peka", "Тотал по геймам больше(22.5)", "31%", "+118.9%"));
        list.add(new DataTopForesastDetails.DataBean.DataUsersBean
                ("peka", "Тотал по геймам больше(22.5)", "31%", "+118.9%"));
        list.add(new DataTopForesastDetails.DataBean.DataUsersBean
                ("peka", "Тотал по геймам больше(22.5)", "31%", "+118.9%"));
        return list;
    }

    @Override
    protected int getMenuResId() {
        return R.menu.topforecast_menu_toolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.top_forecast_filter_menu:
                return true;
            case R.id.top_forecast_star_menu:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setBtnKf(View view){
        Intent intent = new Intent(TopForecastDetails.this, TopForecastKf.class);
        startActivity(intent);
    }

}