package com.kuda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kuda.adapter.CustomAdaptor;
import com.kuda.model.RecommendProject;
import com.kuda.model.TrendingProject;
import com.kuda.adapter.TrendingProjectAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    SharedPrefManager sharedPrefManager = new SharedPrefManager(this);

    HorizontalInfiniteCycleViewPager viewPager;
    List<TrendingProject> trendingProjectList = new ArrayList<>();

    RecyclerView viewListRecommendProject;
    List<RecommendProject> projectList;

    String temp = null;

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
                        startActivity(new Intent(getApplicationContext(),SearchActivity.class));
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
                        temp = getIntent().getStringExtra("token");
//                        sharedPrefManager.getSP_Token(SharedPrefManager.SP_Token, temp);
                        if (temp == null)   {
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                        }   else {
                            startActivity(new Intent(getApplicationContext(), UserProfile.class));
                        }
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;
                }
                return false;
            }
        });

        viewListRecommendProject = findViewById(R.id.list_recommend_project);

        projectList = new ArrayList<>();

        projectList.add(new RecommendProject("1ayam","Teknologi","Deskripsi tentang Ayam ayam ndadsadn adnasdsan nasdad an asdadn asdasd an  nasdnasdansdna asdnasnd ansdasdn asdnasdn asnda sdn asdadnnasd nasd","Rp.12.500.000","50%",R.drawable.bumblebee,R.drawable.logo_univ_ipb));
        projectList.add(new RecommendProject("2bebek","Pertanian"," of time. Aweee it. At thatpoint, I the hot washing spot? I would prefernot to let you know nowte thostinations.Ideally we can meet sompanion.","Rp.525.800.000","80%",R.drawable.logo_univ_ui,R.drawable.logo_univ_ugm));
        projectList.add(new RecommendProject("3kambing","Kesehatan","Deskripsi tentang Kambing","Rp.10.000.000","10%",R.drawable.john_wick,R.drawable.logo_univ_telkom));
        projectList.add(new RecommendProject("4gagak","Teknologi","Deskripsi tentang Gagak","Rp.22.400.000","32%",R.drawable.bumblebee,R.drawable.logo_univ_ui));
        projectList.add(new RecommendProject("5cacing","Teknologi","Deskripsi tentang Ayam ayam ndadsadn adnasdsan nasdad an asdadn asdasd an  nasdnasdansdna asdnasnd ansdasdn asdnasdn asnda sdn asdadnnasd nasd","Rp.12.500.000","50%",R.drawable.bumblebee,R.drawable.logo_univ_ipb));
        projectList.add(new RecommendProject("6burung","Pertanian"," of time. Aweee it. At thatpoint, I the hot washing spot? I would prefernot to let you know nowte thostinations.Ideally we can meet sompanion.","Rp.55.800.000","80%",R.drawable.aquaman,R.drawable.logo_univ_ugm));
        projectList.add(new RecommendProject("7kelabang","Kesehatan","Deskripsi tentang Kambing","Rp.10.000.000","10%",R.drawable.john_wick,R.drawable.logo_univ_telkom));
        projectList.add(new RecommendProject("8cicak","Teknologi","Deskripsi tentang Gagak","Rp.22.400.000","32%",R.drawable.bumblebee,R.drawable.logo_univ_ui));

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewListRecommendProject.setLayoutManager(manager1);

        CustomAdaptor adaptorRecommendProject = new CustomAdaptor(this,projectList);
        viewListRecommendProject.setAdapter(adaptorRecommendProject);

    }

    private void initData(){
        trendingProjectList.add(new TrendingProject("1","1ayam","Teknologi","Deskripsi tentang Ayam","Rp.12.500.000","50%",R.drawable.bumblebee,R.drawable.logo_univ_ipb));
        trendingProjectList.add(new TrendingProject("2","1bebek","Pertanian","Deskripsi tentang Bebek","Rp.55.800.000","80%",R.drawable.aquaman,R.drawable.logo_univ_ugm));
        trendingProjectList.add(new TrendingProject("3","1kambing","Kesehatan","Deskripsi tentang Kambing","Rp.10.000.000","10%",R.drawable.john_wick,R.drawable.logo_univ_telkom));
        trendingProjectList.add(new TrendingProject("4","1gagak","Teknologi","Deskripsi tentang Gagak","Rp.22.400.000","32%",R.drawable.bumblebee,R.drawable.logo_univ_ui));
    }

//
//    public void toDetails(View view) {
//        Intent intent = new Intent(this, DetailsProjectActivity.class);
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//        startActivity(intent);
//    }
}
