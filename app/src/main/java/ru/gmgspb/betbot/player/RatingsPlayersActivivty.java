package ru.gmgspb.betbot.player;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.BaseActivity;

public class RatingsPlayersActivivty extends BaseActivity{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ratings_playres;
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected int getMenuResId() {
        return R.menu.forecasts_menu_toolbar;
    }
}
