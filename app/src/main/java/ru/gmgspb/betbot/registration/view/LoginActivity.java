package ru.gmgspb.betbot.registration.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.forecast.view.ForecastsSearchActivity;
import ru.gmgspb.betbot.main.view.MainActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        final Button btnLogin = (Button) findViewById(R.id.sign_btn_login);
        final Button btnRegister = (Button) findViewById(R.id.sign_btn_regist);
        final EditText editLogin = (EditText) findViewById(R.id.sign_edittxt_login);

        editLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editLogin.getText().toString().equals("")){
                    btnLogin.setBackgroundResource(R.drawable.btn_signin);
                    btnRegister.setBackgroundResource(R.drawable.btn_register_notactive);
                    btnRegister.setTextColor(Color.parseColor("#f44336"));
                } else {
                    btnLogin.setBackgroundResource(R.drawable.btn_signin_active);
                    btnRegister.setBackgroundResource(R.drawable.btn_register_active);
                    btnRegister.setTextColor(Color.parseColor("#ffffff"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void forgotPasswordActivity(View view){
        Intent intent = new Intent(LoginActivity.this, ForgotPasword_Activity.class);
        startActivity(intent);
    }

    public void registerActivity (View view){
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void forecastActivity(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
