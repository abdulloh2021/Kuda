package com.kuda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.kuda.databinding.ActivityDetailsProjectBinding;
import com.kuda.fragment.DetailsProjectSectionAdapter;

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
        getSupportActionBar().setDisplayShowTitleEnabled(false);

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

    private void setValues() {
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        // get the text from MainActivity
        Intent intent = getIntent();
        String trendingProjectTitle = intent.getStringExtra("tpTitle");
        String trendingProjectCategory = intent.getStringExtra("tpCategory");
        String trendingProjectGoal = intent.getStringExtra("tpGoal");
        String trendingProjectProgress = intent.getStringExtra("tpProgress");

        // use the text in a TextView
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        TextView tvCategory = (TextView) findViewById(R.id.tvCategory);
        TextView tvGoal = (TextView) findViewById(R.id.tvGoal);
        TextView tvProgress = (TextView) findViewById(R.id.tvProgress);
        ImageView ivImage1 = (ImageView) findViewById(R.id.iv);

        tvTitle.setText(trendingProjectTitle);
        tvCategory.setText(trendingProjectCategory);
        tvGoal.setText(trendingProjectGoal);
        tvProgress.setText(trendingProjectProgress);
        ivImage1.setImageBitmap(bmp);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    public void toPayment(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
