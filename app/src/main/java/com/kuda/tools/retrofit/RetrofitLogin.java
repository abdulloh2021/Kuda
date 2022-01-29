package com.kuda.tools.retrofit;

import com.kuda.model.api.LoginApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitLogin {

    private static  RetrofitLogin instance=null;

    private LoginApi myAPI;

    private RetrofitLogin(){
        Retrofit retrofit =new Retrofit.Builder().baseUrl(LoginApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myAPI=retrofit.create(LoginApi.class);
    }

    public static synchronized  RetrofitLogin getInstance(){
        if(instance == null){
            instance=new RetrofitLogin();
        }
        return instance;
    }

    public LoginApi getMyAPI(){
        return myAPI;
    }

}
