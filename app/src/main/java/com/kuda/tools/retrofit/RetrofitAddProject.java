package com.kuda.tools.retrofit;

import com.kuda.model.api.AddProjectApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAddProject {

    private static RetrofitAddProject instance = null;

    private AddProjectApi myAPI;

    private RetrofitAddProject() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(AddProjectApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myAPI = retrofit.create(AddProjectApi.class);
    }

    public static synchronized RetrofitAddProject getInstance() {
        if (instance == null) {
            instance = new RetrofitAddProject();
        }
        return instance;
    }

    public AddProjectApi getMyAPI() {
        return myAPI;
    }
}
