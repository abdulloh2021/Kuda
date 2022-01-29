package com.kuda.model.api;

import com.kuda.model.obj.AddProjectObj;
import com.kuda.model.obj.ResponseLoginObj;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AddProjectApi {

    static String BASE_URL = "http://b477-180-254-242-135.ngrok.io";

    @POST("api/auth/register")
    Call<ResponseLoginObj> registerProcess(@Body AddProjectObj object);

}
