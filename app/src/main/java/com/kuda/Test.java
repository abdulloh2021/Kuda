package com.kuda;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Test extends AppCompatActivity {
    int targetDana;
    int danaMasuk;
    int localDate;
    int tenggatWaktu;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        targetDana = 100; danaMasuk = 100;
        localDate = 6; tenggatWaktu = 5;
        TextView tv = (TextView) findViewById(R.id.statusProgress);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
            if(danaMasuk < targetDana) {
                pb.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_funding));
                tv.setText("Funding Process");
            } else {
                pb.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_success));
                tv.setText("Project Success!");
                tv.setTextColor(getResources().getColor(R.color.whitey));
            }
            if(localDate > tenggatWaktu && danaMasuk < targetDana) {
                pb.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_failed));
                tv.setText("Project Gagal Maning");
                tv.setTextColor(getResources().getColor(R.color.whitey));
            }
        pb.setProgress(danaMasuk); pb.setMax(targetDana);

    }
}