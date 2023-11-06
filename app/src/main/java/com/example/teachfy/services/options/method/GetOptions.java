package com.example.teachfy.services.options.method;

import com.example.teachfy.RetrofitInitializer;
import com.example.teachfy.models.Option;
import com.example.teachfy.models.User;
import com.example.teachfy.services.options.response.GetOptionsResponse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;

public class GetOptions {

    private int cardId;

    public GetOptions(int cardId){
        this.cardId= cardId;
    }

    public List<Option> getOptionsFromCardId(){
        RetrofitInitializer api = new RetrofitInitializer();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<List<Option>> cardFuture = executorService.submit(() -> {
            Call<GetOptionsResponse> call = api.optionService().getOptions(User.getLogedToken(), cardId);
            try {
                GetOptionsResponse response = call.execute().body();
                if (response != null) {
                    return response.getOptions();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        // Aguarde a conclusão da tarefa assíncrona e obtenha o resultado
        List<Option> optionsResponse = null;
        try {
            optionsResponse = cardFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        return optionsResponse;
    }

}
