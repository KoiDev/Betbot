package ru.gmgspb.betbot.registration.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import ru.gmgspb.betbot.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);

        final EditText editLogin = (EditText)findViewById(R.id.reg_edittxt_login);
        final Button btnRegistration = (Button)findViewById(R.id.reg_btn_registration);

        editLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editLogin.getText().toString().equals("")){
                    btnRegistration.setBackgroundResource(R.drawable.btn_register_active);
                    btnRegistration.setTextColor(Color.parseColor("#ffffff"));
                } else {
                    btnRegistration.setBackgroundResource(R.drawable.btn_register_notactive);
                    btnRegistration.setTextColor(Color.parseColor("#f44336"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
