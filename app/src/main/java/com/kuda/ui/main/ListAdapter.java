package com.kuda.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kuda.R;
import com.kuda.model.Projects;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Projects> {

    public ListAdapter(Context context, ArrayList<Projects> array) {
        super(context, 0, array);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent)  {
        View currentItemView  = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        }
        Projects currentNumberPosition = getItem(position);

        ImageView numbersImage = currentItemView.findViewById(R.id.bullet);
        assert currentNumberPosition != null;
        numbersImage.setImageResource(currentNumberPosition.getImageId());

        TextView textView1 = currentItemView.findViewById(R.id.projects);
        textView1.setText(currentNumberPosition.getProjectName());

        TextView tv = currentItemView.findViewById(R.id.statusProgress);
        tv.setText(currentNumberPosition.getStatus());

        ProgressBar pb = currentItemView.findViewById(R.id.progressBar);
        pb.setProgress(currentNumberPosition.getDanaMasuk());
        pb.setMax(currentNumberPosition.getTargetDana());

        if(currentNumberPosition.getDanaMasuk() < currentNumberPosition.getTargetDana()) {
            pb.setProgressDrawable(getContext().getResources().getDrawable(R.drawable.progress_bar_funding));
        } else {
            pb.setProgressDrawable(getContext().getResources().getDrawable(R.drawable.progress_bar_success));
            tv.setTextColor(getContext().getResources().getColor(R.color.whitey));
        }
        if(currentNumberPosition.getLocalDate() > currentNumberPosition.getTenggatWaktu() &&
            currentNumberPosition.getDanaMasuk() < currentNumberPosition.getTargetDana()) {
            tv.setTextColor(getContext().getResources().getColor(R.color.whitey));
            pb.setProgressDrawable(getContext().getResources().getDrawable(R.drawable.progress_bar_failed));
        }

        return currentItemView;
    }
}
