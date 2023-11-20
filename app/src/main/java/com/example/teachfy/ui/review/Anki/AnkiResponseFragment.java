package com.example.teachfy.ui.review.Anki;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AnkiResponseViewModel.class);
        // TODO: Use the ViewModel
    }

}