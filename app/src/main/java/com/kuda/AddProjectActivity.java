package com.kuda;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kuda.model.obj.AddProjectObj;
import com.kuda.model.obj.ResponseLoginObj;
import com.kuda.tools.retrofit.RetrofitAddProject;

import java.io.File;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProjectActivity extends AppCompatActivity {

    EditText categories, name, summary,dateline, fundTarget;

    private static final int PICK_JPG_FILE = 1;
    private static final int PICK_PDF_FILE = 2;
    TextView phovi, portofolio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        phovi = findViewById(R.id.text4);
        portofolio = findViewById(R.id.text5);
        categories =  findViewById(R.id.edittext3);
        name = findViewById(R.id.edittext1);
        summary = findViewById(R.id.edittext2);
        dateline = findViewById(R.id.edittext4);
        fundTarget = findViewById(R.id.edittext5);

    }

    public void selectFile(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/jpeg");
        startActivityForResult(intent, PICK_JPG_FILE);

    }

    public void selectPdf(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        startActivityForResult(intent, PICK_PDF_FILE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            // The result data contains a URI for the document or directory that
            // the user selected.
            phovi.setText(data.getData().getPath());
            Uri uri = null;
            if (data != null) {
                uri = data.getData();
                // Perform operations on the document using its URI.
            }
        }
        if (requestCode == 2 && resultCode == Activity.RESULT_OK) {
            // The result data contains a URI for the document or directory that
            // the user selected.
            portofolio.setText(data.getData().getPath());
            Uri uri = null;
            if (data != null) {
                uri = data.getData();
                // Perform operations on the document using its URI.
            }
        }
    }

    public void termCheck(View view) {
    }

    public void submitProject(View view) {
        AddProjectObj obj =new AddProjectObj();
        obj.setName(name.getText().toString());
        obj.setFundTarget(fundTarget.getText().toString());
        obj.setCategories(categories.getText().toString());
        obj.setSummary(summary.getText().toString());
        obj.setDateline(dateline.getText().toString());
        obj.setPhovi(phovi.getText().toString());
        obj.setPortofolio(new File(portofolio.getText().toString()));

        Call<ResponseLoginObj> call = RetrofitAddProject.getInstance().getMyAPI().registerProcess(obj);
        call.enqueue(new Callback<ResponseLoginObj>() {
            @Override
            public void onResponse(Call<ResponseLoginObj> call, Response<ResponseLoginObj> response) {
                ResponseLoginObj resp = response.body();
                Toast.makeText(getApplicationContext(), resp.getMessage().toString(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), DetailsProjectActivity.class));
            }

            @Override
            public void onFailure(Call<ResponseLoginObj> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println(t);
            }
        });

    }
}
