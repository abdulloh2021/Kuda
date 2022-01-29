package com.kuda;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        setValues();

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
}
