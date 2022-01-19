package com.kuda;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kuda.model.RecommendProject;
import com.kuda.ui.main.CustomAdaptor;

import java.util.ArrayList;
import java.util.List;

public class ListActivityTester extends AppCompatActivity {

    RecyclerView mList1,mList2;
    List<RecommendProject> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tester);

        mList1 = findViewById(R.id.list1);
        mList2 = findViewById(R.id.list2);
        projectList = new ArrayList<>();

        projectList.add(new RecommendProject(R.drawable.john_wick,"Youtube1",40));
        projectList.add(new RecommendProject(R.drawable.aquaman,"Max Player1",30));
        projectList.add(new RecommendProject(R.drawable.bumblebee,"Messenger1",20));
        projectList.add(new RecommendProject(R.drawable.aquaman,"Twitter1",22));
        projectList.add(new RecommendProject(R.drawable.john_wick,"VLC Player1",40));
        projectList.add(new RecommendProject(R.drawable.bumblebee,"Whatsapp1",34));

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList2.setLayoutManager(manager2);

        CustomAdaptor adaptor1 = new CustomAdaptor(this,projectList);
        mList1.setAdapter(adaptor1);

        CustomAdaptor adaptor2 = new CustomAdaptor(this,projectList);
        mList2.setAdapter(adaptor2);
    }
}