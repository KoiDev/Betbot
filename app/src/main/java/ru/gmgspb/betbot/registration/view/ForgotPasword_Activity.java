package ru.gmgspb.betbot.registration.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import ru.gmgspb.betbot.R;

public class ForgotPasword_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_pasword);

        final Button btnForgot = (Button)findViewById(R.id.forgotpas_sendbattn);
        final EditText editEmail = (EditText)findViewById(R.id.forgotpas_email);
        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (editEmail.getText().toString().equals("")) {
                    btnForgot.setBackgroundResource(R.drawable.btn_forgot_pass_noactive);
                } else btnForgot.setBackgroundResource(R.drawable.btn_forgot_pass_active);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
