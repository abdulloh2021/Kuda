package com.kuda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DisbursementActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String [] bank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disbursement);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Spinner spinn = findViewById(R.id.dropdown_bank);
        spinn.setOnItemSelectedListener(this);
        bank = getResources().getStringArray(R.array.bank_transaksi);
        ArrayAdapter ad = new ArrayAdapter(DisbursementActivity.this, R.layout.support_simple_spinner_dropdown_item, bank);
        ad.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinn.setAdapter(ad);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        ((TextView) adapterView.getChildAt(0)).setTextSize(25);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onSendMoney(View view) {
        Toast.makeText(getBaseContext(), "Money Sent", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
