package com.example.teachfy.services.review.method;

import com.example.teachfy.RetrofitInitializer;
import com.example.teachfy.models.Option;
import com.example.teachfy.models.User;
import com.example.teachfy.services.options.response.GetOptionsResponse;
import com.example.teachfy.services.review.response.GetAllFromDeckResponse;

import org.json.JSONStringer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;

public class GetAllFromDeck {


    public GetAllFromDeckResponse getAllFromDeck(int deck_id){
        RetrofitInitializer api = new RetrofitInitializer();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<GetAllFromDeckResponse> cardFuture = executorService.submit(() -> {
            Call<GetAllFromDeckResponse> call = api.reviewService().getAllFromDeck(User.getLogedToken(), deck_id);
            try {
                GetAllFromDeckResponse response = call.execute().body();
                if (response != null) {
                    return response;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        // Aguarde a conclusão da tarefa assíncrona e obtenha o resultado
        GetAllFromDeckResponse data = null;
        try {
            data = cardFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        return data;
    }
}
