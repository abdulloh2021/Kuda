package com.kuda.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.kuda.R;
import com.kuda.model.TrendingProject;

import java.util.List;

public class TrendingProjectAdapter extends PagerAdapter {
    Context context;
    List<TrendingProject> trendingProjectList;

    public TrendingProjectAdapter(Context context, List<TrendingProject> trendingProjectList) {
        this.context = context;
        this.trendingProjectList = trendingProjectList;
    }

    @Override
    public int getCount() {
        return trendingProjectList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false);

        ImageView trending_project_image = (ImageView) view.findViewById(R.id.trending_project_image);
        ImageView trending_project_image_univ = (ImageView) view.findViewById(R.id.trending_project_image_univ);
        TextView trending_project_title = (TextView) view.findViewById(R.id.trending_project_title);
        TextView trending_project_category = (TextView) view.findViewById(R.id.trending_project_category);
        TextView trending_project_description_min = (TextView) view.findViewById(R.id.trending_project_description_min);
        TextView trending_project_goal = (TextView) view.findViewById(R.id.trending_project_goal);
        TextView trending_project_progress = (TextView) view.findViewById(R.id.trending_project_progress);


        trending_project_image.setImageResource(trendingProjectList.get(position).getImage());
        trending_project_image_univ.setImageResource(trendingProjectList.get(position).getImage_univ());
        trending_project_title.setText(trendingProjectList.get(position).getTrending_project_title());
        trending_project_category.setText(trendingProjectList.get(position).getTrending_project_category());
        trending_project_description_min.setText(trendingProjectList.get(position).getTrending_project_description_min());
        trending_project_goal.setText(trendingProjectList.get(position).getTrending_project_goal());
        trending_project_progress.setText(trendingProjectList.get(position).getTrending_project_progress());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,""+trendingProjectList.get(position).getTrending_project_title(),Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view);
        return view;
    }
}
