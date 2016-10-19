package ru.gmgspb.betbot.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.analiz.AnalizActivivty;
import ru.gmgspb.betbot.bukmeker.RatingsBukmekerActivity;
import ru.gmgspb.betbot.forecast.view.ForecastsSearchActivity;
import ru.gmgspb.betbot.live.view.LiveActivity;
import ru.gmgspb.betbot.main.view.MainActivity;
import ru.gmgspb.betbot.message.MessageActivity;
import ru.gmgspb.betbot.player.RatingsPlayersActivivty;
import ru.gmgspb.betbot.robobet.view.RobobetActivity;
import ru.gmgspb.betbot.forecasttop.view.TopForecast;

public abstract class BaseActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setLayoutView();
        setToolBar();
        setupViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(getMenuResId(), menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;}
        }
        return true;
    }

    private void setLayoutView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.container);
        viewStub.setLayoutResource(getLayoutId());
        viewStub.inflate();
    }

    private void setToolBar() {
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_default);
        ab.setDisplayHomeAsUpEnabled(true);
        setNavigationDrawer();
    }

    private void setNavigationDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Class classToStart = null;
                if (item.getItemId() == R.id.forecasts_search) {
                    classToStart = ForecastsSearchActivity.class;
                } else if (item.getItemId() == R.id.robobet) {
                    classToStart = RobobetActivity.class;
                } else if (item.getItemId() == R.id.top_rates) {
                    classToStart = TopForecast.class;
                } else if (item.getItemId() == R.id.forecasts_feed) {
                    classToStart = MainActivity.class;
                } else if (item.getItemId() == R.id.live) {
                    classToStart = LiveActivity.class;
                } else if (item.getItemId() == R.id.message) {
                    classToStart = MessageActivity.class;
                } else if (item.getItemId() == R.id.game_analysis) {
                    classToStart = AnalizActivivty.class;
                } else if (item.getItemId() == R.id.players_rankings) {
                    classToStart = RatingsPlayersActivivty.class;
                } else if (item.getItemId() == R.id.bukmakers_rankings) {
                    classToStart = RatingsBukmekerActivity.class;
                }

                BaseActivity activity = BaseActivity.this;
                if (activity.getClass().equals(classToStart)) {
                    mDrawerLayout.closeDrawers();
                } else {
                    Intent intent = new Intent(activity, classToStart);
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    protected abstract int getLayoutId();
    protected abstract void setupViews();
    protected abstract int getMenuResId();
}
