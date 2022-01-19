package com.kuda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class SettingBankAccountActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_bank_account);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ArrayList<BanksView> bankList = new ArrayList<BanksView>();
        bankList.add(new BanksView("BCA", "Tessy WRH - 6165165",R.drawable.delete_button));
        bankList.add(new BanksView("Mandiri", "Tessy WRH - 7894444",R.drawable.delete_button));
        bankList.add(new BanksView("Danamon", "Tessy WRH - 321351",R.drawable.delete_button));

        BanksViewAdapter numbersArrayAdapter = new BanksViewAdapter(this, bankList);
        ListView numbersListView = findViewById(R.id.listBank);
        numbersListView.setAdapter(numbersArrayAdapter);
    }

    public void onSave(View view) {
        Toast.makeText(this, "Save Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}