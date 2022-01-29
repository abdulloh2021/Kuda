package com.kuda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kuda.model.obj.ResponseLoginObj;
import com.kuda.model.obj.SignUpObj;
import com.kuda.tools.retrofit.RetrofitSignUp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    EditText userName, email, password, conf_pass, question, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        userName=(EditText) findViewById(R.id.userName);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        conf_pass=(EditText) findViewById(R.id.confirmPass);
        question=(EditText) findViewById(R.id.question);
        answer=(EditText) findViewById(R.id.answer);
    }

    public void toLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void signup(View view) {
        SignUpObj Obj = new SignUpObj();
        Obj.setName(userName.getText().toString());
        Obj.setEmail(email.getText().toString());
        Obj.setPassword(password.getText().toString());
        Obj.setPassword_confirmation(conf_pass.getText().toString());
        Obj.setQuestion(question.getText().toString());
        Obj.setAnswer(answer.getText().toString());
        Obj.setDevice_name("mobile");

        Call<ResponseLoginObj> call = RetrofitSignUp.getInstance().getMyAPI().registerProcess(Obj);
        call.enqueue(new Callback<ResponseLoginObj>() {
            @Override
            public void onResponse(Call<ResponseLoginObj> call, Response<ResponseLoginObj> response) {
                ResponseLoginObj Response = response.body();
                Toast.makeText(getApplicationContext(), Response.getMessage().toString(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("token", Obj.getEmail().toString());
                startActivity(i);
            }

            @Override
            public void onFailure(Call<ResponseLoginObj> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
