package com.example.teachfy.ui.review.Anki;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.teachfy.R;

public class AnkiResponseFragment extends Fragment {

    private AnkiResponseViewModel mViewModel;

    public static AnkiResponseFragment newInstance() {
        return new AnkiResponseFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anki_response, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button finalizar = view.findViewById(R.id.buttonFinalizarRevisaoAnki);
        Button errei = view.findViewById(R.id.buttonErro);
        Button acerto = view.findViewById(R.id.buttonAcerto);

        acerto.setOnClickListener( v ->{
            NavDirections action = AnkiResponseFragmentDirections.actionAnkiResponseFragmentToAnkiQuestionFragment();

            NavHostFragment.findNavController(this).navigate(action);
        });


        errei.setOnClickListener( v ->{
            NavDirections action = AnkiResponseFragmentDirections.actionAnkiResponseFragmentToAnkiQuestionFragment();

            NavHostFragment.findNavController(this).navigate(action);
        });


        finalizar.setOnClickListener(v -> {
            NavDirections action = AnkiResponseFragmentDirections.actionGlobalNavigationHome();

            NavHostFragment.findNavController(this).navigate(action);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AnkiResponseViewModel.class);
        // TODO: Use the ViewModel
    }

}