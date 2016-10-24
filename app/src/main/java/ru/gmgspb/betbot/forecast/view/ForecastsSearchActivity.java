package ru.gmgspb.betbot.forecast.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.MenuItem;

import retrofit2.Call;
import retrofit2.Callback;
import ru.gmgspb.betbot.forecast.adapter.ForecastAdapter;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.DataForecast;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.BaseActivity;
import ru.gmgspb.betbot.network.repository.ForecastService;

public class ForecastsSearchActivity extends BaseActivity {
    ForecastsCustomDialog cd;

    public static final String TAG = "KoiDev";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forecasts_search;
    }

    @Override
    protected int getMenuResId() {
        return R.menu.forecasts_menu_toolbar;
    }

    @Override
    protected void setupViews() {
        initRecycler();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.forecast_filter:
                showFilter();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showFilter(){
        cd = new ForecastsCustomDialog(ForecastsSearchActivity.this);
        cd.show();
    }

    private void initRecycler() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.forecast_recview);
        StaggeredGridLayoutManager mStaggeredGridLayoutManager =
                new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        ForecastApi service = ForecastService.getInstance(getBaseContext()).getApi();
        final Call<DataForecast> dataForecastCall = service.getListForecast();

        dataForecastCall.enqueue(new Callback<DataForecast>() {

            @Override
            public void onResponse(Call<DataForecast> call, retrofit2.Response<DataForecast> response) {

                DataForecast dataForecast = response.body();
                ForecastAdapter adapter = new ForecastAdapter(dataForecast.getData());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<DataForecast> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}