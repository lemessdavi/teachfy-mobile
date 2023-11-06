package com.example.teachfy.ui.createCard.avaliativo;

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
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.teachfy.R;
import com.example.teachfy.models.Card;
import com.example.teachfy.services.card.methods.PostCard;
import com.example.teachfy.services.card.request.PostCardRequest;
import com.example.teachfy.services.options.method.PostOption;
import com.example.teachfy.services.options.request.PostOptionRequest;
import com.example.teachfy.ui.createCard.anki.NewCardAnkiFragmentArgs;
import com.google.android.material.textfield.TextInputEditText;

public class NewCardAvaliativoFragment extends Fragment {

    private NewCardAvaliativoViewModel mViewModel;

    public static NewCardAvaliativoFragment newInstance() {
        return new NewCardAvaliativoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_card_avaliativo, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button finalizar = view.findViewById(R.id.buttonFinalizarDeckAvaliativo);
        Button proximoCard = view.findViewById(R.id.buttonProximoCardAvaliativo);

        EditText opt1 = view.findViewById(R.id.editTextOpt1);
        RadioButton op1 = view.findViewById(R.id.option1);

        EditText opt2 = view.findViewById(R.id.editTextOpt2);
        RadioButton op2 = view.findViewById(R.id.option2);

        EditText opt3 = view.findViewById(R.id.editTextOpt3);
        RadioButton op3 = view.findViewById(R.id.option3);

        EditText opt4 = view.findViewById(R.id.editTextOpt4);
        RadioButton op4 = view.findViewById(R.id.option4);

        TextInputEditText pergunta = view.findViewById(R.id.textInputEditTextPerguntaAvaliativo);

        NavController navigation = NavHostFragment.findNavController(NewCardAvaliativoFragment.this);

        finalizar.setOnClickListener(viewAL -> {
            Card card = postCard(pergunta.getText().toString());
            postOption(card.getId(),opt1.getText().toString(), op1.isChecked());
            postOption(card.getId(),opt2.getText().toString(), op2.isChecked());
            postOption(card.getId(),opt3.getText().toString(), op3.isChecked());
            postOption(card.getId(),opt4.getText().toString(), op4.isChecked());
            navigation.navigate(R.id.action_global_navigation_home);
        });

        proximoCard.setOnClickListener(viewAL -> {
            Card card = postCard(pergunta.getText().toString());
            postOption(card.getId(),opt1.getText().toString(), op1.isChecked());
            postOption(card.getId(),opt2.getText().toString(), op2.isChecked());
            postOption(card.getId(),opt3.getText().toString(), op3.isChecked());
            postOption(card.getId(),opt4.getText().toString(), op4.isChecked());

            NewCardAvaliativoFragmentDirections.ActionNewCardAvaliativo action = NewCardAvaliativoFragmentDirections.actionNewCardAvaliativo(card.getDeck_id(), card.getDeck_type());
            navigation.navigate(action);
        });
    }

    private Card postCard(String question) {
        int deck_id = com.example.teachfy.ui.createCard.anki.NewCardAnkiFragmentArgs.fromBundle(getArguments()).getDeckId();
        int deck_type = NewCardAnkiFragmentArgs.fromBundle(getArguments()).getDeckType();
        int type = 2;

        PostCardRequest request = new PostCardRequest();
        request.setDeck_id(deck_id);
        request.setType(type);
        request.setDeck_type(deck_type);
        request.setQuestion(question);

        PostCard postCard = new PostCard(request);
        return postCard.saveCard();
    }

    private void postOption(int cardId, String description, boolean isCorrect){
        PostOptionRequest req = new PostOptionRequest();
        req.setCard_id(cardId);
        req.setDescription(description);
        req.setCorrect_answer(isCorrect);

        PostOption postOption = new PostOption(req);
        postOption.saveOption();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewCardAvaliativoViewModel.class);
        // TODO: Use the ViewModel
    }

}