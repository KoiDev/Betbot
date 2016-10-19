package ru.gmgspb.betbot.forecast.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ru.gmgspb.betbot.R;

public class ForecastsCustomDialog extends Dialog {
    public Activity c;
    public Button findButton;
    public TextView dforch_kindsofsports, dforch_typeforecasts, dforch_profitforecaster,
                    dforch_roi, dforch_passability, dforch_category, dforch_bank,
                    dforch_ratetype, dforch_coefficient,dforch_amountforecasts, dforch_sorting,
                    dforch_nextmatches, dforch_lastmatches,dforch_date,dforch_eventnumber;

    public RadioGroup dforch_radiobutt;
    public RelativeLayout dforch_box_typeforecasts;

    public ForecastsCustomDialog(Activity a){
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_forc_searchfilter);
        dforch_kindsofsports = (TextView) findViewById(R.id.dforch_kindsofsports);
        dforch_typeforecasts = (TextView) findViewById(R.id.dforch_typeforecasts);
        dforch_radiobutt = (RadioGroup) findViewById(R.id.dforch_radiobutt);
        dforch_box_typeforecasts = (RelativeLayout) findViewById(R.id.dforch_box_typeforecasts);

        findButton = (Button) findViewById(R.id.dforch_btn);

        myClickListner();
    }

    private void myClickListner() {
        dforch_kindsofsports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dforch_radiobutt.getVisibility()==View.GONE){
                    dforch_radiobutt.setVisibility(View.VISIBLE);
                }else {dforch_radiobutt.setVisibility(View.GONE);}
            }
        });

        dforch_typeforecasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dforch_box_typeforecasts.getVisibility()==View.GONE){
                    dforch_box_typeforecasts.setVisibility(View.VISIBLE);
                }else {dforch_box_typeforecasts.setVisibility(View.GONE);}
            }
        });

        dforch_radiobutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dforch_box_typeforecasts.setVisibility(View.GONE);}

        });

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


}
