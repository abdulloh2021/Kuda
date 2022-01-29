package com.kuda.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kuda.BanksView;
import com.kuda.R;

import java.util.ArrayList;

public class BanksViewAdapter extends ArrayAdapter<BanksView> {
    private AlertDialog mDialog;
    private int mListRowPosition;
    public BanksViewAdapter(Context context, ArrayList<BanksView> arrayList) {
        super(context, 0, arrayList);

        AlertDialog.Builder builder = new AlertDialog.Builder((context));
        builder.setMessage("Delete This Bank Account?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yeupp!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();
            }
        })
        .setNegativeButton("Nope, nvm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // User cancelled the dialog
            }
        });
        mDialog = builder.create();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.recycler_add_bank, parent, false);
        }
        BanksView currentNumberPosition = getItem(position);

        TextView textView1 = currentItemView.findViewById(R.id.bank);
        textView1.setText(currentNumberPosition.getBankName());
        TextView textView2 = currentItemView.findViewById(R.id.bankDet);
        textView2.setText(currentNumberPosition.getBankDetails());
        ImageView numbersImage = currentItemView.findViewById(R.id.bankDeleteButt);
        assert currentNumberPosition != null;
        numbersImage.setImageResource(currentNumberPosition.getImageId());
        numbersImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(position);
            }
        });

        return currentItemView;
    }

    private void showDialog(int position) {
        mListRowPosition = position;
        if(mDialog != null)
            mDialog.show();
    }
}
