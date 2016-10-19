package ru.gmgspb.betbot.forecasttop.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ru.gmgspb.betbot.common.BaseActivity;
import ru.gmgspb.betbot.forecasttop.adapter.TopForecastAdapter;
import ru.gmgspb.betbot.network.entity.DataTopForecast;
import ru.gmgspb.betbot.R;

public class TopForecast extends BaseActivity {

    String[] spinnerSport = { "ВИДЫ СПОРТА", "ФУТБОЛ", "ХОККЕЙ", "БАСКЕТБОЛ", "ТЕННИС", "БЕЙСБОЛ", "ВОЛЕЙБОЛ"};

    RecyclerView recyclerView;
    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.top_forecast_rv_toplist);
        StaggeredGridLayoutManager manager =
                new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        TopForecastAdapter adapter = new TopForecastAdapter(initData());
        recyclerView.setAdapter(adapter);
    }

    private void initSpinner(){
        final Spinner spinner = (Spinner) findViewById(R.id.top_forecast_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item , spinnerSport);
        spinner.setAdapter(adapter);
    }

    private List<DataTopForecast.DataBean> list;

    private List<DataTopForecast.DataBean> initData() {
        list = new ArrayList<>();
        list.add(new DataTopForecast.DataBean("29.03\n2016", "Анахайм", "Калгари", "Хоккей / NHL. Регулярный", "+112"));
        list.add(new DataTopForecast.DataBean("29.03\n2016", "Анахайм", "Калгари", "Хоккей / NHL. Регулярный", "+113"));
        list.add(new DataTopForecast.DataBean("29.03\n2016", "Анахайм", "Калгари", "Хоккей / NHL. Регулярный", "+114"));
        list.add(new DataTopForecast.DataBean("29.03\n2016", "Анахайм", "Калгари", "Хоккей / NHL. Регулярный", "+115"));
        list.add(new DataTopForecast.DataBean("29.03\n2016", "Анахайм", "Калгари", "Хоккей / NHL. Регулярный", "+116"));
        return list;
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_forecast;
    }

    @Override
    protected void setupViews() {
        initRecyclerView();
        initSpinner();
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
}
