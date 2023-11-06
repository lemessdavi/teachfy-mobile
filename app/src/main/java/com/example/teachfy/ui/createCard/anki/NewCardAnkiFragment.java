package com.example.teachfy.ui.createCard.anki;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.teachfy.R;
import com.example.teachfy.services.card.methods.PostCard;
import com.example.teachfy.services.card.request.PostCardRequest;
import com.google.android.material.textfield.TextInputEditText;

public class NewCardAnkiFragment extends Fragment {

    private NewCardAnkiViewModel mViewModel;
    private NavController navigation ;


    public static NewCardAnkiFragment newInstance() {
        return new NewCardAnkiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_card_anki, container, false);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button finalizar = view.findViewById(R.id.buttonFinalizarDeckAnki);
        Button proximoCard = view.findViewById(R.id.buttonProximoCardAnki);

        TextInputEditText frente = view.findViewById(R.id.textInputFrenteCardAnki);
        TextInputEditText verso = view.findViewById(R.id.textInputVersoCardAnki);

        navigation = NavHostFragment.findNavController(NewCardAnkiFragment.this);

        int deck_id = NewCardAnkiFragmentArgs.fromBundle(getArguments()).getDeckId();
        int deck_type = NewCardAnkiFragmentArgs.fromBundle(getArguments()).getDeckType();

        NewCardAnkiFragmentDirections.ActionNewCardAnki action =
                NewCardAnkiFragmentDirections.actionNewCardAnki(deck_id, deck_type);

        finalizar.setOnClickListener(viewAL -> {
            postCard(frente.getText().toString(), verso.getText().toString());
            navigation.navigate(R.id.action_global_navigation_home);
        });

        proximoCard.setOnClickListener(viewAL ->{
            postCard(frente.getText().toString(), verso.getText().toString());
            navigation.navigate(action);
        });
    }
    private void postCard(String question, String answer) {
        int deck_id = NewCardAnkiFragmentArgs.fromBundle(getArguments()).getDeckId();
        int deck_type = NewCardAnkiFragmentArgs.fromBundle(getArguments()).getDeckType();
        int type = 2;

        PostCardRequest request = new PostCardRequest();
        request.setDeck_id(deck_id);
        request.setType(type);
        request.setDeck_type(deck_type);
        request.setQuestion(question);
        request.setAnswer(answer);

        PostCard postCard = new PostCard(request);
        postCard.saveCard();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewCardAnkiViewModel.class);
        // TODO: Use the ViewModel
    }

}