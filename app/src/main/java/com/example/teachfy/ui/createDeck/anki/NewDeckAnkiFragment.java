package com.example.teachfy.ui.createDeck.anki;

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
import com.example.teachfy.ui.createDeck.avaliativo.NewDeckAvaliativoFragment;
import com.example.teachfy.ui.createDeck.avaliativo.NewDeckAvaliativoFragmentDirections;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

public class NewDeckAnkiFragment extends Fragment {

    private NewDeckAnkiViewModel mViewModel;
    Button create;

    public static NewDeckAnkiFragment newInstance() {
        return new NewDeckAnkiFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_deck_anki, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        create = view.findViewById(R.id.buttonCriarDeckAnki);
        TextInputEditText titulo = view.findViewById(R.id.textInputTituloAnki);
        TextInputEditText description = view.findViewById(R.id.textInputDescricaoAnki);
        CheckBox ispublic = view.findViewById(R.id.checkBoxDeckPublicoAnki);

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_creation_method);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.CENTER);

        Button manual = dialog.findViewById(R.id.buttonManualCreation);
        Button generate = dialog.findViewById(R.id.buttonAIGeneration);

        create.setOnClickListener(viewAL -> dialog.show());

        NavController navigator = NavHostFragment.findNavController(NewDeckAnkiFragment.this);

        manual.setOnClickListener(view1 -> {
            try {
                PostDeck postDeck = new PostDeck(titulo.getText().toString(), description.getText().toString(), ispublic.isChecked(), 2);

                Deck deck = postDeck.saveDeck();

                NewDeckAnkiFragmentDirections.ActionNewDeckAnkiFragment2ToNewCardAnkiFragment actionNewDeckAnkiFragment2ToNewCardAnkiFragment =
                        NewDeckAnkiFragmentDirections.actionNewDeckAnkiFragment2ToNewCardAnkiFragment(deck.getId(), deck.getType());

                actionNewDeckAnkiFragment2ToNewCardAnkiFragment.setDeckId(deck.getId());
                actionNewDeckAnkiFragment2ToNewCardAnkiFragment.setDeckType(deck.getType());
                navigator.navigate(actionNewDeckAnkiFragment2ToNewCardAnkiFragment);

                dialog.dismiss();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        generate.setOnClickListener(v -> {
            dialog.dismiss();
            navigator.navigate(R.id.action_newDeckAnkiFragment2_to_generateCardsFragment);
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewDeckAnkiViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onDestroyView() {;
        super.onDestroyView();
    }



}


