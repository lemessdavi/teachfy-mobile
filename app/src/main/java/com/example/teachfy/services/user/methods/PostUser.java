package com.example.teachfy.services.user.methods;

import com.example.teachfy.RetrofitInitializer;
import com.example.teachfy.models.Deck;
import com.example.teachfy.models.User;
import com.example.teachfy.services.deck.response.PostDeckResponse;
import com.example.teachfy.services.user.request.PostUserRequest;
import com.example.teachfy.services.user.response.PostUserResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;

public class PostUser {

    public User saveUser(String nome, String email, String senha, String confirmacaoSenha){
        RetrofitInitializer api = new RetrofitInitializer();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        PostUserRequest user = new PostUserRequest();
        user.setName(nome);
        user.setEmail(email);
        user.setPassword(senha);
        user.setPassword_confirmation(confirmacaoSenha);

        Future<PostUserResponse> userFuture = executorService.submit(() -> {
            Call<PostUserResponse> call = api.userService()
                    .postUser(user);
            try {
                PostUserResponse response = call.execute().body();
                if (response != null) {
                    return response;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        PostUserResponse userResponse = null;
        try {
            userResponse = userFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //mas praticas :P
        String token = userResponse.getData().getToken();
        User.logarUsuario(token);

        executorService.shutdown();

        return userResponse.getData();
    }
}
