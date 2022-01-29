package com.kuda.fragment;

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
import com.kuda.model.Projects;
import com.kuda.adapter.ListAdapter;

import java.util.ArrayList;

public class ProjectsFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_projects, container, false);

        final ArrayList<Projects> arrayList = new ArrayList<Projects>();
        arrayList.add(new Projects(R.drawable.bulletpoint,"Solar Cell",100,95,1,7,
            "Funding Process","Technology","TECH1021205654",R.drawable.bumblebee,R.drawable.logo_univ_ipb));
        arrayList.add(new Projects(R.drawable.bulletpoint,"Wavepower",100,150,9,7,
            "Project Success!","Technology","TECH1021205654",R.drawable.bumblebee,R.drawable.logo_univ_ipb));
        arrayList.add(new Projects(R.drawable.bulletpoint,"Math Solar",100,65,9,7,
            "Project Gagal Maning","Technology","TECH1021205654",R.drawable.bumblebee,R.drawable.logo_univ_ipb));

        ListAdapter adapter = new ListAdapter(getActivity(), arrayList);
        ListView listView = (ListView)view.findViewById(R.id.createdList);
        listView.setAdapter(adapter);
        return view;
    }

}
