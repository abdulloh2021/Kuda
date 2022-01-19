package com.kuda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.kuda.databinding.ActivityDetailsProjectBinding;
import com.kuda.databinding.ActivityUserProfileBinding;
import com.kuda.fragment.DetailsProjectSectionAdapter;
import com.kuda.ui.main.SectionsPagerAdapter;

public class DetailsProjectActivity extends AppCompatActivity {

    int targetDana;
    int danaMasuk;
    int localDate;
    int tenggatWaktu;

    private ActivityDetailsProjectBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_project);

        binding = ActivityDetailsProjectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DetailsProjectSectionAdapter sectionsPagerAdapter = new DetailsProjectSectionAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.vpDetailsProject;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarDet);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        TextView linkFAQ = findViewById(R.id.faq);
        linkFAQ.setMovementMethod(LinkMovementMethod.getInstance());
        TextView linkToU = findViewById(R.id.tou);
        linkToU.setMovementMethod(LinkMovementMethod.getInstance());
        TextView linkPrivacy = findViewById(R.id.privacy);
        linkPrivacy.setMovementMethod(LinkMovementMethod.getInstance());

        targetDana = 100;
        danaMasuk = 30;
        localDate = 4;
        tenggatWaktu = 5;

        TextView danaMas = (TextView) findViewById(R.id.danaMasuk);
        danaMas.setText(Integer.toString(danaMasuk));
        TextView target = (TextView) findViewById(R.id.targetDana);
        target.setText(Integer.toString(targetDana));

        TextView tv = (TextView) findViewById(R.id.progressStatus);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progress);
        if (danaMasuk < targetDana) {
            pb.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_funding));
            tv.setText("Funding Process");
        } else {
            pb.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_success));
            tv.setText("Project Success!");
            tv.setTextColor(getResources().getColor(R.color.whitey));
        }
        if (localDate > tenggatWaktu && danaMasuk < targetDana) {
            pb.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_failed));
            tv.setText("Project Gagal Maning");
            tv.setTextColor(getResources().getColor(R.color.whitey));
        }
        pb.setProgress(danaMasuk);
        pb.setMax(targetDana);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}