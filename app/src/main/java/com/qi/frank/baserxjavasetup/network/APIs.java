package com.qi.frank.baserxjavasetup.network;

import com.qi.frank.baserxjavasetup.model.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIs {


    @GET("/api/v1/users/show")
    Observable<User> getUser();

    @FormUrlEncoded
    @POST("/api/v1/users/change_password")
    Observable<Boolean> changePassword(@Field("password") String password,
                               @Field("confirm_password") String confirm_password);
}
