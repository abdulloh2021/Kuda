package com.kuda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendProject {
    private String recommend_project_title,recommend_project_category,recommend_project_description_min,recommend_project_goal,recommend_project_progress;
    private int image,image_univ;
}
