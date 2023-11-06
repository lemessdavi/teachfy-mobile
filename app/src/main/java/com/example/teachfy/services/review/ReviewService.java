package com.example.teachfy.services.review;

import com.example.teachfy.services.deck.response.GetDecksResponse;
import com.example.teachfy.services.review.response.GetAllFromDeckResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ReviewService {

    @GET("allfromdeck/{id}")
    Call<GetAllFromDeckResponse> getAllFromDeck(@Header("authorization") String token, @Path("id") int deck_id);
}
