package com.example.teachfy.ui.createCard.ia;

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

public class GenerateCardsFragment extends Fragment {

    private GenerateCardsViewModel mViewModel;

    public static GenerateCardsFragment newInstance() {
        return new GenerateCardsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_generate_cards, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button generateCards = view.findViewById(R.id.buttonGenerateCards);

        NavController navigator = NavHostFragment.findNavController(GenerateCardsFragment.this);

        generateCards.setOnClickListener(viewAL -> {
            navigator.navigate(R.id.action_global_navigation_home);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GenerateCardsViewModel.class);
        // TODO: Use the ViewModel
    }

}