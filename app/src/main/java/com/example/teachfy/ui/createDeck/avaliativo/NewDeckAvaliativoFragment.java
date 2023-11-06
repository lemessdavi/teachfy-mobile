package com.example.teachfy.ui.createDeck.avaliativo;

import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.teachfy.R;
import com.example.teachfy.models.Deck;
import com.example.teachfy.services.deck.methods.PostDeck;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

public class NewDeckAvaliativoFragment extends Fragment {

    private NewDeckAvaliativoViewModel mViewModel;

    public static NewDeckAvaliativoFragment newInstance() {
        return new NewDeckAvaliativoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_new_deck_avaliativo, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button create = view.findViewById(R.id.buttonCriarDeckAvaliativo);

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_creation_method);

        Button manual = dialog.findViewById(R.id.buttonManualCreation);
        Button generate = dialog.findViewById(R.id.buttonAIGeneration);

        TextInputEditText titulo = view.findViewById(R.id.textInputTituloAvaliativo);
        TextInputEditText description = view.findViewById(R.id.textInputDescricaoAvaliativo);
        CheckBox ispublic = view.findViewById(R.id.checkBoxDeckPublicoAvaliativo);

        NavController navigator = NavHostFragment.findNavController(NewDeckAvaliativoFragment.this);

        manual.setOnClickListener(view1 -> {
            try {
                PostDeck postDeck = new PostDeck(titulo.getText().toString(), description.getText().toString(), ispublic.isSelected(), 1);

                Deck deck = postDeck.saveDeck();

                NewDeckAvaliativoFragmentDirections.ActionNewDeckAvaliativoFragmentToNewCardAvaliativoFragment action =
                        NewDeckAvaliativoFragmentDirections.actionNewDeckAvaliativoFragmentToNewCardAvaliativoFragment(deck.getId(), deck.getType());

                action.setDeckId(deck.getId());
                action.setDeckType(deck.getType());
                NavHostFragment.findNavController(NewDeckAvaliativoFragment.this).navigate(action);

                dialog.dismiss();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        generate.setOnClickListener(v -> {
            dialog.dismiss();
            navigator.navigate(R.id.action_newDeckAvaliativoFragment_to_generateCardsFragment);
        });

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.CENTER);

        create.setOnClickListener(viewAL -> dialog.show());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewDeckAvaliativoViewModel.class);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}