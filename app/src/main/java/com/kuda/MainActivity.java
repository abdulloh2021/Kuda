package com.kuda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kuda.model.TrendingProject;
import com.kuda.ui.main.TrendingProjectAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HorizontalInfiniteCycleViewPager viewPager;
    List<TrendingProject> trendingProjectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Trending Project
        initData();
        viewPager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.view_pager);
        TrendingProjectAdapter adapter = new TrendingProjectAdapter(this,trendingProjectList);
        viewPager.setAdapter(adapter);
        //End Trending Project

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(),TestCategoryActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;

                    case R.id.add:
                        startActivity(new Intent(getApplicationContext(),AddProjectActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;

                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),UserProfile.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;

                }
                return false;
            }
        });
    }


    private void initData(){
        trendingProjectList.add(new TrendingProject("1ayam","Teknologi","Deskripsi tentang Ayam","Rp.12.500.000","50%",R.drawable.bumblebee,R.drawable.logo_univ_ipb));
        trendingProjectList.add(new TrendingProject("1bebek","Pertanian","Deskripsi tentang Bebek","Rp.55.800.000","80%",R.drawable.aquaman,R.drawable.logo_univ_ugm));
        trendingProjectList.add(new TrendingProject("1kambing","Kesehatan","Deskripsi tentang Kambing","Rp.10.000.000","10%",R.drawable.john_wick,R.drawable.logo_univ_telkom));
        trendingProjectList.add(new TrendingProject("1gagak","Teknologi","Deskripsi tentang Gagak","Rp.22.400.000","32%",R.drawable.bumblebee,R.drawable.logo_univ_ui));
    }

    public void toLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(intent);
    }

    public void toDisburst(View view) {
        Intent intent = new Intent(this, DisbursementActivity.class);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(intent);
    }

    public void toDetails(View view) {
        Intent intent = new Intent(this, DetailsProjectActivity.class);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(intent);
    }
}