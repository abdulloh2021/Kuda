package com.kuda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kuda.model.obj.LoginObj;
import com.kuda.model.obj.ResponseLoginObj;
import com.kuda.tools.retrofit.RetrofitLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

//    SharedPrefManager sharedPrefManager = new SharedPrefManager(this);

    EditText username, password;
    Button btnLogin;
    float v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

        username.setTranslationX(1000);
        password.setTranslationX(1000);
        btnLogin.setTranslationY(1000);

        username.setAlpha(v);
        password.setAlpha(v);
        btnLogin.setAlpha(v);

        username.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        btnLogin.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    public void toSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void login(View view) {

        LoginObj obj = new LoginObj();
        obj.setEmail(username.getText().toString());
        obj.setPassword(password.getText().toString());
        obj.setDevice_name("mobile");

        Call<ResponseLoginObj> call = RetrofitLogin.getInstance().getMyAPI().loginProcess(obj);
        call.enqueue(new Callback<ResponseLoginObj>() {
            @Override
            public void onResponse(Call<ResponseLoginObj> call, Response<ResponseLoginObj> response) {
                ResponseLoginObj Response = response.body();
                Toast.makeText(getApplicationContext(), Response.getMessage().toString(), Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                String mt = Response.getMeta().toString();
                i.putExtra("token", mt);
//                sharedPrefManager.saveSPString(SharedPrefManager.SP_Token, mt);
//                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_LoggedIn, true);
                startActivity(i);

            }

            @Override
            public void onFailure(Call<ResponseLoginObj> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void toForgot(View view) {
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
}
