package com.example.sajib.retrofitsimple23;

import com.example.sajib.retrofitsimple23.modelpackege.UserBody;
import com.example.sajib.retrofitsimple23.modelpackege.UserReturn;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    @POST("api/web/post-data/customer-insert")
    public Call<UserReturn> getUser(@Body UserBody userBody);
}
