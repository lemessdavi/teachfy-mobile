package com.example.teachfy.services.options.method;

import com.example.teachfy.RetrofitInitializer;
import com.example.teachfy.models.Option;
import com.example.teachfy.models.User;
import com.example.teachfy.services.options.request.PostOptionRequest;
import com.example.teachfy.services.options.response.PostOptionsResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;

public class PostOption {

    private PostOptionRequest request;
    public PostOption(PostOptionRequest request){
        this.request = request;
    }

    public Option saveOption(){
        RetrofitInitializer api = new RetrofitInitializer();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Option> cardFuture = executorService.submit(() -> {
            Call<PostOptionsResponse> call = api.optionService().postOptions(User.getLogedToken(), request);
            try {
                PostOptionsResponse response = call.execute().body();
                if (response != null) {
                    return response.getOption();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        // Aguarde a conclusão da tarefa assíncrona e obtenha o resultado
        Option optionsResponse = null;
        try {
            optionsResponse = cardFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        return optionsResponse;
    }
}
