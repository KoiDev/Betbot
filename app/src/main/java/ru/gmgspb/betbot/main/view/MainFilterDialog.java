package ru.gmgspb.betbot.main.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gmgspb.betbot.R;


public class MainFilterDialog extends Dialog {

    public Activity c;

    @BindView(R.id.main_dialog_group1)
    LinearLayout group1LinearLayout;
    @BindView(R.id.main_dialog_group2)
    LinearLayout group2LinearLayout;
    @BindView(R.id.main_dialog_forecast_btn)
    Button forecastButton;
    @BindView(R.id.main_dialog_sports_btn)
    Button sportsButton;
    @BindView(R.id.main_dialog_find_btn)
    Button findButton;

    public MainFilterDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_main_search_filter);

        ButterKnife.bind(this);

        clickListner();

    }

    private void clickListner() {
        forecastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (group1LinearLayout.getVisibility() == View.GONE){
                    group1LinearLayout.setVisibility(View.VISIBLE);
                    group2LinearLayout.setVisibility(View.GONE);
                } else {
                    group1LinearLayout.setVisibility(View.GONE);
                }
            }
        });

        sportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (group2LinearLayout.getVisibility() == View.GONE){
                    group2LinearLayout.setVisibility(View.VISIBLE);
                    group1LinearLayout.setVisibility(View.GONE);
                } else {
                    group2LinearLayout.setVisibility(View.GONE);
                }
            }
        });

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
