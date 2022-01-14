package com.kuda.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.kuda.MainActivity;
import com.kuda.R;
import com.kuda.UserProfile;

import java.util.ArrayList;

public class ProjectsFragment extends Fragment implements View.OnClickListener {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_projects, container, false);
        Button homeButton = view.findViewById(R.id.homeButt);
        homeButton.setOnClickListener(this);

        final ArrayList<Projects> arrayList = new ArrayList<Projects>();
        arrayList.add(new Projects(R.drawable.bulletpoint,"Solar Cell","Funding"));
        arrayList.add(new Projects(R.drawable.bulletpoint,"Wavepower","Gagal"));
        arrayList.add(new Projects(R.drawable.bulletpoint,"Math Solar","Success"));

        ListAdapter adapter = new ListAdapter(getActivity(), arrayList);
        ListView listView = (ListView)view.findViewById(R.id.createdList);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())   {
            case R.id.homeButt:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
        }
    }
}