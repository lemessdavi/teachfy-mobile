package com.example.teachfy.services.user;

import com.example.teachfy.services.user.request.PostLoginRequest;
import com.example.teachfy.services.user.request.PostUserRequest;
import com.example.teachfy.services.user.response.DeleteUserResponse;
import com.example.teachfy.services.user.response.PostLoginResponse;
import com.example.teachfy.services.user.response.PostUserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("users")
    Call<PostUserResponse> postUser(@Body PostUserRequest user);

    @POST("login")
    Call<PostLoginResponse> postLogin(@Body PostLoginRequest login);

    @GET("migrate-fresh")
    Call<DeleteUserResponse> freshDatabase();
}
