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

public class SettingPaymentActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickListener {
    RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_payment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ArrayList<String> arrayPayment = new ArrayList<>();
        arrayPayment.add("Cards");
        arrayPayment.add("Bank Transfer");
        arrayPayment.add("E-Wallet");
        arrayPayment.add("Indomaret/Alfamart");

        RecyclerView recyclerView = findViewById(R.id.rvPayment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, arrayPayment);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + (position+1), Toast.LENGTH_SHORT).show();
    }
}