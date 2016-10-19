package ru.gmgspb.betbot.bukmeker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.BaseActivity;

public class RatingsBukmekerActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ratings_bukmeker;
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected int getMenuResId() {
        return R.menu.forecasts_menu_toolbar;
    }
}
