package com.example.teachfy.services.user;

import com.example.teachfy.services.user.request.PostLoginRequest;
import com.example.teachfy.services.user.request.PostUserRequest;
import com.example.teachfy.services.user.response.PostLoginResponse;
import com.example.teachfy.services.user.response.PostUserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("users")
    Call<PostUserResponse> postUser(@Body PostUserRequest user);

    @POST("login")
    Call<PostLoginResponse> postLogin(@Body PostLoginRequest login);
}
