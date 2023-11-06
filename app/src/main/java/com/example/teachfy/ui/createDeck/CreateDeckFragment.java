package com.example.teachfy.ui.createDeck;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.teachfy.R;
import com.example.teachfy.databinding.FragmentNewdeckBinding;
import android.graphics.Color;

public class CreateDeckFragment extends Fragment {

    private FragmentNewdeckBinding binding;
    LinearLayout anki;

    LinearLayout avaliativo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_modal_newdeck);

        anki = dialog.findViewById(R.id.optionAnki);
        avaliativo = dialog.findViewById(R.id.optionAvaliativo);

        anki.setOnClickListener(view -> {
            dialog.dismiss();
            NavHostFragment.findNavController(CreateDeckFragment.this).navigate(R.id.action_to_newDeckAnkiFragment);
        });

        avaliativo.setOnClickListener(v -> {
            dialog.dismiss();
            NavHostFragment.findNavController(CreateDeckFragment.this).navigate(R.id.newDeckAvaliativoFragment);
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CreateDeckViewModel createDeckViewModel =
                new ViewModelProvider(this).get(CreateDeckViewModel.class);

        binding = FragmentNewdeckBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}