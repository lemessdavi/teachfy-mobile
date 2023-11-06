package com.example.teachfy.services.card.methods;

import com.example.teachfy.RetrofitInitializer;
import com.example.teachfy.models.Card;
import com.example.teachfy.models.User;
import com.example.teachfy.services.card.request.PostCardRequest;
import com.example.teachfy.services.card.response.PostCardResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;

public class PostCard {
    PostCardRequest request;

    Card cardResponse;

    public PostCard(PostCardRequest request) {
        this.request = request;
    }

    public Card saveCard() {
        RetrofitInitializer api = new RetrofitInitializer();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Card> cardFuture = executorService.submit(() -> {
            Call<PostCardResponse> call = api.cardService().postCard(User.getLogedToken(), request);
            try {
                PostCardResponse response = call.execute().body();
                if (response != null) {
                    return response.getCard();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        Card cardResponse = null;
        try {
            cardResponse = cardFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        return cardResponse;
    }

}
