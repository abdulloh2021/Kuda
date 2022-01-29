package com.kuda.model.api;

import com.kuda.model.obj.LoginObj;
import com.kuda.model.obj.ResponseLoginObj;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    static String BASE_URL = "http://b477-180-254-242-135.ngrok.io";

    @POST("api/auth/login")
    Call<ResponseLoginObj> loginProcess(@Body LoginObj object);

}
