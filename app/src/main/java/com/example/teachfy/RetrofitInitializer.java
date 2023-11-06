package com.example.teachfy;


import com.example.teachfy.services.card.CardService;
import com.example.teachfy.services.deck.DeckService;
import com.example.teachfy.services.options.OptionService;
import com.example.teachfy.services.review.ReviewService;
import com.example.teachfy.services.user.UserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitInitializer {
    private final Retrofit retrofit;

    public RetrofitInitializer() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(new RequestLoggingInterceptor()).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public DeckService deckService(){
        return retrofit.create(DeckService.class);
    }

    public CardService cardService(){ return retrofit.create(CardService.class);}

    public OptionService optionService(){return  retrofit.create(OptionService.class);}

    public ReviewService reviewService(){return  retrofit.create(ReviewService.class);}

    public UserService userService(){return  retrofit.create(UserService.class);}
}