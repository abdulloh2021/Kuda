package com.kuda.model.obj;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProjectObj {

    private String categories;
    private String name;
    private String phovi;
    private File portofolio;
    private String summary;
    private String dateline;
    private String fundTarget;

}
