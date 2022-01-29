package com.kuda.model;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {
    private int bulletId;
    private String projectName;
    private int targetDana;
    private int danaMasuk;
    private int localDate;
    private int tenggatWaktu;
    private String status;
    private String category;
    private String id;
    private int image;
    private int imageUniv;

    public static Comparator<Projects> idAscending = new Comparator<Projects>()
    {
        @Override
        public int compare(Projects project1, Projects project2)
        {
            int id1 = Integer.valueOf(project1.getId());
            int id2 = Integer.valueOf(project2.getId());

            return Integer.compare(id1, id2);
        }
    };

    public static Comparator<Projects> nameAscending = new Comparator<Projects>()
    {
        @Override
        public int compare(Projects project1, Projects project2)
        {
            String name1 = project1.getProjectName();
            String name2 = project2.getProjectName();
            name1 = name1.toLowerCase();
            name2 = name2.toLowerCase();

            return name1.compareTo(name2);
        }
    };

}


