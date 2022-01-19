package com.kuda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {
    private int imageId;
    private String projectName;
    private int targetDana;
    private int danaMasuk;
    private int localDate;
    private int tenggatWaktu;
    private String status;

}


