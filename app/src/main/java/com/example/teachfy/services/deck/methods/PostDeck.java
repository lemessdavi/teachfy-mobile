package com.example.teachfy.services.deck.methods;

import com.example.teachfy.RetrofitInitializer;
import com.example.teachfy.models.Deck;
import com.example.teachfy.models.User;
import com.example.teachfy.services.deck.request.PostDeckRequest;
import com.example.teachfy.services.deck.response.PostDeckResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;

public class PostDeck {

    private Deck deckResponse;

    private PostDeckRequest deck;

    public PostDeck(String title, String description, boolean publicCheck, int type) throws IOException {
        deck = new PostDeckRequest();
        deck.setName(title);
        deck.setDescription(description);
        deck.setPublicDeck(publicCheck);
        deck.setType(type);
    }

    public Deck saveDeck() {
        RetrofitInitializer api = new RetrofitInitializer();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Deck> deckFuture = executorService.submit(() -> {
            Call<PostDeckResponse> call = api.deckService()
                    .createDeck(User.getLogedToken(), deck);
            try {
                PostDeckResponse response = call.execute().body();
                if (response != null) {
                    return response.getDeck();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        Deck deckResponse = null;
        try {
            deckResponse = deckFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        return deckResponse;
    }
}
