package com.example.teachfy.services.deck.methods;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.teachfy.RetrofitInitializer;
import com.example.teachfy.adapters.DeckAdpter;
import com.example.teachfy.models.Deck;
import com.example.teachfy.models.User;
import com.example.teachfy.services.deck.response.GetDecksResponse;
import com.example.teachfy.ui.home.HomeFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDecks {
    List<Deck> decksList;
    private RecyclerView recyclerView;
    private Context ctx;
    private HomeFragment clickListener;

    public GetDecks(Context ctx, RecyclerView recyclerView, HomeFragment clickListener) {
        this.recyclerView = recyclerView;
        this.ctx = ctx;
        this.clickListener = clickListener;
    }

    public void getDecks() {
        RetrofitInitializer api = new RetrofitInitializer();

        Call<GetDecksResponse> call =  api.deckService().getDecks(User.getLogedToken());

        call.enqueue(new Callback<GetDecksResponse>() {
            @Override
            public void onResponse(Call<GetDecksResponse> call, Response<GetDecksResponse> response) {
                GetDecksResponse dto  = response.body();
                try{
                    decksList = dto.getDeckRequests();
                }  catch (NullPointerException ignored){

                }

                DeckAdpter deckAdpter = new DeckAdpter(ctx, decksList);
                deckAdpter.setClickListener(clickListener);
                recyclerView.swapAdapter(deckAdpter, false);
            }

            @Override
            public void onFailure(Call<GetDecksResponse> call, Throwable t) {
                Log.e("onFailure: ", "Erro ao acessar: " + t.getMessage() );
            }
        });
    }
}
