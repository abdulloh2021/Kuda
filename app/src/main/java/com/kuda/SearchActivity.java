package com.kuda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kuda.adapter.ProjectAdapter;
import com.kuda.model.Projects;

import java.util.ArrayList;
import java.util.Collections;

public class SearchActivity extends AppCompatActivity {

    public static ArrayList<Projects> projectList = new ArrayList<Projects>();
    private ListView listView;
    private Button sortButton;
    private Button filterButton;
    private LinearLayout filterView1;
    private LinearLayout filterView2;
    private LinearLayout sortView;

    boolean sortHidden = true;
    boolean filterHidden = true;

    private Button circleButton, squareButton, rectangleButton, triangleButton, octagonButton, allButton;
    private Button idAscButton, idDescButton, nameAscButton, nameDescButton;

    private ArrayList<String> selectedFilters = new ArrayList<String>();
    private String currentSearchText = "";
    private SearchView searchView;

    private int white, darkGray, red;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initSearchWidgets();
        initWidgets();
        setupData();
        setUpList();
        setUpOnclickListener();
        hideFilter();
        hideSort();
        initColors();
        lookSelected(idAscButton);
        lookSelected(allButton);
        selectedFilters.add("all");

        //=========================================== navigation control ===========================================

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.search);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;

                    case R.id.search:

                        return true;

                    case R.id.add:
                        startActivity(new Intent(getApplicationContext(),AddProjectActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;

                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), UserProfile.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;

                }
                return false;
            }
        });
        //=========================================== end navigation control ===========================================

    }

    private void initColors()
    {
        white = ContextCompat.getColor(getApplicationContext(), R.color.whitey);
        red = ContextCompat.getColor(getApplicationContext(), R.color.navy);
        darkGray = ContextCompat.getColor(getApplicationContext(), R.color.abu);
    }

    private void unSelectAllSortButtons()
    {
        lookUnSelected(idAscButton);
        lookUnSelected(idDescButton);
        lookUnSelected(nameAscButton);
        lookUnSelected(nameDescButton);
    }

    private void unSelectAllFilterButtons()
    {
        lookUnSelected(allButton);
        lookUnSelected(circleButton);
        lookUnSelected(rectangleButton);
        lookUnSelected(octagonButton);
        lookUnSelected(triangleButton);
        lookUnSelected(squareButton);
    }

    private void lookSelected(Button parsedButton)
    {
        parsedButton.setTextColor(white);
        parsedButton.setBackgroundColor(red);
    }

    private void lookUnSelected(Button parsedButton)
    {
        parsedButton.setTextColor(red);
        parsedButton.setBackgroundColor(darkGray);
    }

    private void initWidgets()
    {
        sortButton = (Button) findViewById(R.id.sortButton);
        filterButton = (Button) findViewById(R.id.filterButton);
        filterView1 = (LinearLayout) findViewById(R.id.filterTabsLayout);
        filterView2 = (LinearLayout) findViewById(R.id.filterTabsLayout2);
        sortView = (LinearLayout) findViewById(R.id.sortTabsLayout2);

        circleButton = (Button) findViewById(R.id.kesehatanFilter);
        squareButton = (Button) findViewById(R.id.pertanianFilter);
        rectangleButton = (Button) findViewById(R.id.perkebunanFilter);
        triangleButton  = (Button) findViewById(R.id.teknologiFilter);
        octagonButton  = (Button) findViewById(R.id.iotFilter);
        allButton  = (Button) findViewById(R.id.allFilter);

        idAscButton  = (Button) findViewById(R.id.idAsc);
        idDescButton  = (Button) findViewById(R.id.idDesc);
        nameAscButton  = (Button) findViewById(R.id.nameAsc);
        nameDescButton  = (Button) findViewById(R.id.nameDesc);
    }

    private void initSearchWidgets()
    {
        searchView = (SearchView) findViewById(R.id.projectListSearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                currentSearchText = s;
                ArrayList<Projects> filteredProjects = new ArrayList<Projects>();

                for(Projects project: projectList)
                {
                    if(project.getProjectName().toLowerCase().contains(s.toLowerCase()))
                    {
                        if(selectedFilters.contains("all"))
                        {
                            filteredProjects.add(project);
                        }
                        else
                        {
                            for(String filter: selectedFilters)
                            {
                                if (project.getProjectName().toLowerCase().contains(filter))
                                {
                                    filteredProjects.add(project);
                                }
                            }
                        }
                    }
                }
                setAdapter(filteredProjects);

                return false;
            }
        });
    }

    private void setupData()
    {
        projectList.add(new Projects(R.drawable.bulletpoint,"Solar Cell",100,95,1,7,
            "Funding Process","Technology","TECH1021205654",R.drawable.bumblebee,R.drawable.logo_univ_ipb));
        projectList.add(new Projects(R.drawable.bulletpoint,"Wavepower",100,150,9,7,
            "Project Success!","Technology","TECH1021205654",R.drawable.john_wick,R.drawable.logo_univ_ipb));

    }
    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.projectsListView);
        setAdapter(projectList);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Projects selectProject = (Projects) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailsProjectActivity.class);
                showDetail.putExtra("id",selectProject.getId());
                startActivity(showDetail);
            }
        });

    }

    private void filterList(String status)
    {
        if(status != null && !selectedFilters.contains(status))
            selectedFilters.add(status);

        ArrayList<Projects> filteredProjects = new ArrayList<Projects>();

        for(Projects project: projectList)
        {
            for(String filter: selectedFilters)
            {
                if(project.getCategory().toLowerCase().contains(filter))
                {
                    if(currentSearchText == "")
                    {
                        filteredProjects.add(project);
                    }
                    else
                    {
                        if(project.getCategory().toLowerCase().contains(currentSearchText.toLowerCase()))
                        {
                            filteredProjects.add(project);
                        }
                    }
                }
            }
        }

        setAdapter(filteredProjects);
    }

    public void allFilterTapped(View view)
    {
        selectedFilters.clear();
        selectedFilters.add("all");

        unSelectAllFilterButtons();
        lookSelected(allButton);
        setAdapter(projectList);
    }

    public void teknologiFilterTapped(View view)
    {
        filterList("teknologi");
        lookSelected(triangleButton);
        lookUnSelected(allButton);
    }

    public void pertanianFilterTapped(View view)
    {
        filterList("pertanian");
        lookSelected(squareButton);
        lookUnSelected(allButton);
    }

    public void iotFilterTapped(View view)
    {
        filterList("iot");
        lookSelected(octagonButton);
        lookUnSelected(allButton);
    }

    public void perkebunanFilterTapped(View view)
    {
        filterList("perkebunan");
        lookSelected(rectangleButton);
        lookUnSelected(allButton);
    }

    public void kesehatanFilterTapped(View view)
    {
        filterList("kesehatan");
        lookSelected(circleButton);
        lookUnSelected(allButton);
    }

    public void showFilterTapped(View view)
    {
        if(filterHidden == true)
        {
            filterHidden = false;
            showFilter();
        }
        else
        {
            filterHidden = true;
            hideFilter();
        }
    }

    public void showSortTapped(View view)
    {
        if(sortHidden == true)
        {
            sortHidden = false;
            showSort();
        }
        else
        {
            sortHidden = true;
            hideSort();
        }
    }

    private void hideFilter()
    {

        filterView1.setVisibility(View.GONE);
        filterView2.setVisibility(View.GONE);
        filterButton.setText("FILTER");
    }

    private void showFilter()
    {

        filterView1.setVisibility(View.VISIBLE);
        filterView2.setVisibility(View.VISIBLE);
        filterButton.setText("HIDE");
    }

    private void hideSort()
    {
        sortView.setVisibility(View.GONE);
        sortButton.setText("SORT");
    }

    private void showSort()
    {
        sortView.setVisibility(View.VISIBLE);
        sortButton.setText("HIDE");
    }

    public void idASCTapped(View view)
    {
        Collections.sort(projectList, Projects.idAscending);
        checkForFilter();
        unSelectAllSortButtons();
        lookSelected(idAscButton);
    }

    public void idDESCTapped(View view)
    {
        Collections.sort(projectList, Projects.idAscending);
        Collections.reverse(projectList);
        checkForFilter();
        unSelectAllSortButtons();
        lookSelected(idDescButton);
    }

    public void nameASCTapped(View view)
    {
        Collections.sort(projectList, Projects.nameAscending);
        checkForFilter();
        unSelectAllSortButtons();
        lookSelected(nameAscButton);
    }

    public void nameDESCTapped(View view)
    {
        Collections.sort(projectList, Projects.nameAscending);
        Collections.reverse(projectList);
        checkForFilter();
        unSelectAllSortButtons();
        lookSelected(nameDescButton);
    }

    private void checkForFilter()
    {
        if(selectedFilters.contains("all"))
        {
            if(currentSearchText.equals(""))
            {
                setAdapter(projectList);
            }
            else
            {
                ArrayList<Projects> filteredProjects = new ArrayList<Projects>();
                for(Projects project: projectList)
                {
                    if(project.getCategory().toLowerCase().contains(currentSearchText))
                    {
                        filteredProjects.add(project);
                    }
                }
                setAdapter(filteredProjects);
            }
        }
        else
        {
            filterList(null);
        }
    }

    private void setAdapter(ArrayList<Projects> projectList)
    {
        ProjectAdapter adapter = new ProjectAdapter(getApplicationContext(), 0, projectList);
        listView.setAdapter(adapter);
    }

}
