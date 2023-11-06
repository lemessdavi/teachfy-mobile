package com.example.teachfy.services.card;

import com.example.teachfy.services.card.request.PostCardRequest;
import com.example.teachfy.services.card.response.PostCardResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface CardService {

    @POST("cards")
    Call<PostCardResponse> postCard(@Header("authorization") String token, @Body PostCardRequest body);
}
