package hessam.rastegari.weroom.connections;

import hessam.rastegari.weroom.data.RegisterClass;
import hessam.rastegari.weroom.data.ResponseClass;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofirServices {

//    @FormUrlEncoded
    @POST("create_user.php")
    Call<ResponseClass> createPost(@Body RegisterClass registerClass);




    @FormUrlEncoded
    @POST("create_user.php")
    Call<ResponseClass> createPostField(
            @Field("firstname") String firstname,
            @Field("surename") String surename,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("token") String token,
            @Field("avatar") String avatar,
            @Field("mood") Integer mood
    );




//    Call<RegisterClass> createPost(
//            @Field("firstname") String firstname,
//            @Field("surename") String surename,
//            @Field("username") String username,
//            @Field("password") String password,
//            @Field("token") String token,
//            @Field("avatar") String avatar,
//            @Field("mood") Integer mood
//    );
}