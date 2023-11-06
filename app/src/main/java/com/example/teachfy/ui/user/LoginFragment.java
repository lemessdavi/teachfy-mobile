package com.example.teachfy.ui.user;

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
import android.widget.EditText;

import com.example.teachfy.R;
import com.example.teachfy.services.user.methods.PostLogin;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button criarConta = view.findViewById(R.id.buttonCriarConta);
        Button login = view.findViewById(R.id.buttonLogin);

        EditText email = view.findViewById(R.id.textInputEmailLogin);
        EditText senha = view.findViewById(R.id.editTextPasswordLogin);

        criarConta.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_createAccountFragment);
        });

        login.setOnClickListener(v -> {
            PostLogin postLogin = new PostLogin();
            postLogin.login(email.getText().toString(), senha.getText().toString());

            NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_navigation_home);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
    }

}