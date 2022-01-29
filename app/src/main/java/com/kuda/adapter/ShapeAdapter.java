package com.kuda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuda.R;
import com.kuda.model.Shape;

import java.util.List;

public class ShapeAdapter extends ArrayAdapter {
    public ShapeAdapter(Context context, int resource, List<Shape> shapeList)
    {
        super(context,resource,shapeList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Shape shape = (Shape) getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_test_shape_cell, parent, false);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.shapeName);
        ImageView iv = (ImageView) convertView.findViewById(R.id.shapeImage);

        tv.setText(shape.getId() + " - " + shape.getName());
        iv.setImageResource(shape.getImage());


        return convertView;
    }
}
