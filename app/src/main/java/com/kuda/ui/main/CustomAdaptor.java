package com.kuda.ui.main;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kuda.R;
import com.kuda.model.RecommendProject;

import java.util.List;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.RecommendProjectHolder> {

    private Context context;
    private List<RecommendProject> recommendProjects;

    public CustomAdaptor(Context context, List<RecommendProject> recommendProjects) {
        this.context = context;
        this.recommendProjects = recommendProjects;
    }

    public class RecommendProjectHolder extends RecyclerView.ViewHolder {
        TextView titleProject,goalProject;
        ImageView imageProject;
        CardView cardView;

        public RecommendProjectHolder(@NonNull View itemView) {
            super(itemView);

            titleProject = itemView.findViewById(R.id.title_project);
            goalProject = itemView.findViewById(R.id.goal_project);
            imageProject = itemView.findViewById(R.id.image_project);
            cardView = itemView.findViewById(R.id.card_project);
        }
    }

    @NonNull
    @Override
    public RecommendProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_list_item,parent,false);


        return new RecommendProjectHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendProjectHolder holder, @SuppressLint("RecyclerView") int position) {

        RecommendProject recommendProject = recommendProjects.get(position);

        holder.titleProject.setText(recommendProject.getName());
        holder.goalProject.setText(recommendProject.getSize()+" %");
        holder.imageProject.setImageResource(recommendProject.getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,""+recommendProject.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return recommendProjects.size();
    }

}
