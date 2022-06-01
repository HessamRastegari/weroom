package hessam.rastegari.weroom.network;

import hessam.rastegari.weroom.data.ResponseClass;
import hessam.rastegari.weroom.data.WelcomeClass;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetroServiceInterface {

    @FormUrlEncoded
    @POST("create_user.php")
    Call<WelcomeClass> createPostField(
            @Field("firstname") String firstname,
            @Field("surename") String surename,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("token") String token,
            @Field("avatar") String avatar,
            @Field("mood") Integer mood
    );

    @FormUrlEncoded
    @POST("create_user.php")
    Call<ResponseBody> createPostFieldResponseBody(
            @Field("firstname") String firstname,
            @Field("surename") String surename,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("token") String token,
            @Field("avatar") String avatar,
            @Field("mood") Integer mood
    );

}
