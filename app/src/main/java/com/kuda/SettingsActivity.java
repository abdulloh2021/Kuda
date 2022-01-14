package com.kuda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kuda.ui.main.RecyclerAdapter;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickListener {
    RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ArrayList<String> arraySetting = new ArrayList<>();
        arraySetting.add("Account");
        arraySetting.add("Edit Profile");
        arraySetting.add("Notifications");
        arraySetting.add("Payment");
        arraySetting.add("Withdrawal");
        arraySetting.add("Delete Account");

        RecyclerView recyclerView = findViewById(R.id.rvSetting);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, arraySetting);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent;
        switch (position)   {
            case 0:
                intent = new Intent(this, SettingAccountActivity.class);
                startActivity(intent);
                break;
            case 1:
                Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + (position), Toast.LENGTH_SHORT).show();
                break;
            case 2:
                intent = new Intent(this, SettingNotificationActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, SettingPaymentActivity.class);
                startActivity(intent);
                break;
            case 4:
                Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + (position), Toast.LENGTH_SHORT).show();
                break;
            case 5:
                intent = new Intent(this, SettingDeleteAccActivity.class);
                startActivity(intent);
                break;
        }
    }
}