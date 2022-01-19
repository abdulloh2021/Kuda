package com.kuda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jakewharton.processphoenix.ProcessPhoenix;

public class SettingDeleteAccActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_delete_acc);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button button = (Button) findViewById(R.id.deleteButt);
            button.setOnClickListener(new View.OnClickListener()   {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SettingDeleteAccActivity.this);
                    builder.setTitle(":(((((((((((((((((((((((((((((((((((((((((((((");
                    builder.setMessage("Are you sure want to delete your account?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yep Bye~", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getBaseContext(), "Account Deleted", Toast.LENGTH_SHORT).show();
                            ProcessPhoenix.triggerRebirth(getApplicationContext());
                        }
                    })
                    .setNegativeButton("Mehh", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
        });
    }
}