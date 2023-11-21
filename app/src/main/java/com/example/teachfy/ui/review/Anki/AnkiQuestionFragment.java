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

import com.example.teachfy.R;

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

        verResposta.setOnClickListener(v -> {
            NavDirections action =  AnkiQuestionFragmentDirections.actionAnkiQuestionFragmentToAnkiResponseFragment();

            NavHostFragment.findNavController(this).navigate(action);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AnkiQuestionViewModel.class);


    }

}