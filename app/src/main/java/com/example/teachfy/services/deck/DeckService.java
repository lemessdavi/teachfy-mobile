package com.example.teachfy.services.deck;

import com.example.teachfy.services.deck.response.GetDecksResponse;
import com.example.teachfy.services.deck.request.PostDeckRequest;
import com.example.teachfy.services.deck.response.PostDeckResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface DeckService {

    @GET("decks")
    Call<GetDecksResponse> getDecks(@Header("authorization") String token);

    @POST("decks")
    Call<PostDeckResponse> createDeck(@Header("authorization") String token, @Body PostDeckRequest deck );
}
