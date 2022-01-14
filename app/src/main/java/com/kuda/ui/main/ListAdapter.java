package com.kuda.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuda.R;

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
        textView1.setText(currentNumberPosition.getCreated());

        TextView textView2 = currentItemView.findViewById(R.id.progress);
        textView2.setText(currentNumberPosition.getText());

        return currentItemView;
    }
}
