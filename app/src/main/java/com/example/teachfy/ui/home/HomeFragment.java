package com.example.teachfy.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teachfy.R;
import com.example.teachfy.adapters.DeckAdpter;
import com.example.teachfy.databinding.FragmentHomeBinding;
import com.example.teachfy.models.Card;
import com.example.teachfy.models.Deck;
import com.example.teachfy.services.deck.methods.GetDecks;
import com.example.teachfy.services.review.method.GetAllFromDeck;
import com.example.teachfy.services.review.response.GetAllFromDeckResponse;
import com.example.teachfy.ui.createCard.anki.NewCardAnkiFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements DeckAdpter.ItemClickListener {
    private FragmentHomeBinding binding;
    private DeckAdpter deckAdpter;
    private List<Deck> decksList;
    private RecyclerView recyclerViewDecks;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        decksList = new ArrayList<>();

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerViewDecks = binding.recyclerViewDecks;
        recyclerViewDecks.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));

        GetDecks request = new GetDecks(getContext(), recyclerViewDecks, this);
        request.getDecks();

        deckAdpter = new DeckAdpter(getContext(), decksList);

        deckAdpter.setClickListener(this);

        recyclerViewDecks.setAdapter(deckAdpter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private List<Deck> mockDecks(){
        ArrayList<Deck> decks = new ArrayList<>();

        Deck d1 = new Deck("70", "Algebra Linear", "25");
        Deck d2 = new Deck("71", "Calculo", "15");
        Deck d3 = new Deck("72", "DDM", "10");
        Deck d4 = new Deck("72", "Metodos quantitaivos", "25");

        decks.add(d1);
        decks.add(d2);
        decks.add(d3);
        decks.add(d4);
        decks.add(d1);
        decks.add(d2);
        decks.add(d3);
        decks.add(d4);
        decks.add(d1);
        decks.add(d2);
        decks.add(d3);
        decks.add(d4);
        decks.add(d1);
        decks.add(d2);
        decks.add(d3);
        decks.add(d4);

        return decks;
    }

    @Override
    public void onItemClick(View view, int position, int deck_id) {
        GetAllFromDeck getAllFromDeck = new GetAllFromDeck();
        GetAllFromDeckResponse data = getAllFromDeck.getAllFromDeck(deck_id);
        List<GetAllFromDeckResponse.Card> cardsList = data.getCards();
        GetAllFromDeckResponse.Card[] cards = cardsList.toArray(new GetAllFromDeckResponse.Card[0]);

        NavDirections action = HomeFragmentDirections.actionNavigationHomeToAnkiQuestionFragment(cards);

        NavController navigation = NavHostFragment.findNavController(HomeFragment.this);
        navigation.navigate(action);
    }
}