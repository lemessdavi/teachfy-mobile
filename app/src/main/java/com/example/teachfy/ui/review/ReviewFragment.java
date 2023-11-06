package com.example.teachfy.ui.review;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teachfy.R;
import com.example.teachfy.services.review.method.GetAllFromDeck;

public class ReviewFragment extends Fragment {

    private ReviewViewModel mViewModel;

    public static ReviewFragment newInstance() {
        return new ReviewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_review, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        int deck_id = ReviewFragmentArgs.fromBundle(getArguments()).getDeckId();
//
//        GetAllFromDeck getAllFromDeck = new GetAllFromDeck();
//        String s = getAllFromDeck.getAllFromDeck(deck_id);
//
//        TextView text = view.findViewById(R.id.bodyReview);
//
//        text.setText(s);

        OnBackPressedCallback callback = new OnBackPressedCallback(true){
            @Override
            public void handleOnBackPressed() {
                NavHostFragment.findNavController(ReviewFragment.this).popBackStack();
            }
        };


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ReviewViewModel.class);
        // TODO: Use the ViewModel
    }

}