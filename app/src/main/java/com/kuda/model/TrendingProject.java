package com.kuda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrendingProject {
    private String id,trending_project_title,trending_project_category,trending_project_description_min,trending_project_goal,trending_project_progress;
    private int image,image_univ;

}
