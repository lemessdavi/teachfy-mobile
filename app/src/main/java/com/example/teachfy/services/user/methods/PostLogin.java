package com.example.teachfy.services.user.methods;

import com.example.teachfy.RetrofitInitializer;
import com.example.teachfy.models.User;
import com.example.teachfy.services.user.request.PostLoginRequest;
import com.example.teachfy.services.user.request.PostUserRequest;
import com.example.teachfy.services.user.response.PostLoginResponse;
import com.example.teachfy.services.user.response.PostUserResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;

public class PostLogin {

    public String login(String email, String senha){
        RetrofitInitializer api = new RetrofitInitializer();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        PostLoginRequest login = new PostLoginRequest();
        login.setEmail(email);
        login.setPassword(senha);

        Future<PostLoginResponse> loginFuture = executorService.submit(() -> {
            Call<PostLoginResponse> call = api.userService()
                    .postLogin(login);
            try {
                PostLoginResponse response = call.execute().body();
                if (response != null) {
                    return response;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        PostLoginResponse loginResponse = null;
        try {
            loginResponse = loginFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //mas praticas :P
        String token = loginResponse.getData().getToken();
        User.logarUsuario(token);

        executorService.shutdown();

        return loginResponse.getData().getToken();
    }
}
