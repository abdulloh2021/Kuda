package com.kuda.model.api;

import com.kuda.model.obj.ResponseLoginObj;
import com.kuda.model.obj.SignUpObj;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpApi {

    static String BASE_URL = "http://b477-180-254-242-135.ngrok.io";

    @POST("api/auth/register")
    Call<ResponseLoginObj> registerProcess(@Body SignUpObj object);
}
