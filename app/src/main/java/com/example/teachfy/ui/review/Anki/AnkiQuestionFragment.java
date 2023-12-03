package com.example.teachfy.ui.review.Anki;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.teachfy.R;
import com.example.teachfy.services.review.response.GetAllFromDeckResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnkiQuestionFragment extends Fragment {

    private AnkiQuestionViewModel mViewModel;

    public static AnkiQuestionFragment newInstance() {
        return new AnkiQuestionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anki_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button verResposta = view.findViewById(R.id.buttonVerResposta);
        TextView question = view.findViewById(R.id.textViewQuestion);

        List<GetAllFromDeckResponse.Card> cards = new ArrayList<>(Arrays.asList(AnkiQuestionFragmentArgs.fromBundle(getArguments()).getCards()));

        GetAllFromDeckResponse.Card card = cards.remove(0);
        question.setText(card.getQuestion());

        GetAllFromDeckResponse.Card[] cardsVetor = cards.toArray(new GetAllFromDeckResponse.Card[0]);
        verResposta.setOnClickListener(v -> {
            NavDirections action =  AnkiQuestionFragmentDirections.actionAnkiQuestionFragmentToAnkiResponseFragment(cardsVetor, card.getAnswer());

            NavHostFragment.findNavController(this).navigate(action);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AnkiQuestionViewModel.class);
    }

}