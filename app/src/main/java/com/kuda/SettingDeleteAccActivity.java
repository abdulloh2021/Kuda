package com.kuda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.kuda.ui.main.ListAdapter;
import com.kuda.ui.main.Projects;
import com.kuda.ui.main.RecyclerAdapter;

import java.util.ArrayList;

public class SettingDeleteAccActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_delete_acc);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final ArrayList<Projects> deletePoint = new ArrayList<Projects>();
        deletePoint.add(new Projects(R.drawable.bulletpoint,getString(R.string.bbrp_dt),null));
        deletePoint.add(new Projects(R.drawable.bulletpoint,getString(R.string.del1),null));
        deletePoint.add(new Projects(R.drawable.bulletpoint,getString(R.string.del2),null));
        deletePoint.add(new Projects(R.drawable.bulletpoint,getString(R.string.del3),null));

        ListAdapter adapter = new ListAdapter(this,deletePoint);
        ListView lview = findViewById(R.id.deletePoint);
        lview.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.deleteButt);
            button.setOnClickListener(new View.OnClickListener()   {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), "Account Deleted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(intent);
                }
        });
    }
}