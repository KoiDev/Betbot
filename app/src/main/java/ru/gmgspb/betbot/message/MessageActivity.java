package ru.gmgspb.betbot.message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.BaseActivity;

public class MessageActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected int getMenuResId() {
        return R.menu.forecasts_menu_toolbar;
    }
}
