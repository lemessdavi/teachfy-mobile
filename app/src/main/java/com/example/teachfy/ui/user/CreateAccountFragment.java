 package com.example.teachfy.ui.user;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.teachfy.R;
import com.example.teachfy.services.user.methods.PostUser;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

 public class CreateAccountFragment extends Fragment {

    private CreateAccountViewModel mViewModel;

    public static CreateAccountFragment newInstance() {
        return new CreateAccountFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_account, container, false);
    }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);

         TextInputEditText nomeEd = view.findViewById(R.id.textInputEdNome);
         TextInputEditText emailEd = view.findViewById(R.id.textInputEdEmail);
         AppCompatEditText senhEd = view.findViewById(R.id.editTextTextPassword);
         AppCompatEditText senhaEdConfirm = view.findViewById(R.id.editTextTextPasswordConfirm);

         Button criarConta = view.findViewById(R.id.buttonCreateAccount);

         criarConta.setOnClickListener(v -> {
             PostUser user = new PostUser();
             String nome = nomeEd.getText().toString();
             String email = emailEd.getText().toString();
             String senha = senhEd.getText().toString();
             String senhaConfirm = senhaEdConfirm.getText().toString();

             user.saveUser(nome, email, senha, senhaConfirm);

             NavHostFragment.findNavController(this).navigate(R.id.action_createAccountFragment_to_navigation_home);
         });

     }

     @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CreateAccountViewModel.class);
        // TODO: Use the ViewModel
    }

}