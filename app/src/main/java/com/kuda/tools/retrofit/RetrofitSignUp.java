package com.kuda.tools.retrofit;

import com.kuda.model.api.SignUpApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSignUp {

    private static  RetrofitSignUp instance=null;

    private SignUpApi myAPI;

    private RetrofitSignUp(){
        Retrofit retrofit =new Retrofit.Builder().baseUrl(SignUpApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myAPI=retrofit.create(SignUpApi.class);
    }

    public static synchronized  RetrofitSignUp getInstance(){
        if(instance == null){
            instance=new RetrofitSignUp();
        }
        return instance;
    }
    public SignUpApi getMyAPI(){
        return myAPI;
    }
}
