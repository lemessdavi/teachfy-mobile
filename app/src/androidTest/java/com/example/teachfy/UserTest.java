package com.example.teachfy;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;

import android.app.Activity;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.teachfy.services.user.UserService;
import com.example.teachfy.services.user.request.PostUserRequest;
import com.example.teachfy.services.user.response.DeleteUserResponse;
import com.example.teachfy.services.user.response.PostUserResponse;
import com.example.teachfy.ui.home.HomeFragment;
import com.example.teachfy.ui.user.CreateAccountFragment;

import java.io.IOException;

import retrofit2.Call;

@RunWith(AndroidJUnit4.class)
public class UserTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void deveFalharAoInformarNomeInvalido() {

        Espresso.onView(ViewMatchers.withId(R.id.buttonCriarConta)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.textInputEdNome)).perform(ViewActions.replaceText(""));
        Espresso.onView(ViewMatchers.withId(R.id.textInputEdEmail)).perform(ViewActions.replaceText("davi@email.com"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPassword)).perform(ViewActions.replaceText("teste1234"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPasswordConfirm)).perform(ViewActions.replaceText("teste1234"));

        Espresso.onView(ViewMatchers.withId(R.id.buttonCreateAccount)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.textViewMeusDecks))
                .check(ViewAssertions.doesNotExist());

        RetrofitInitializer retrofitInitializer = new RetrofitInitializer();

        Call<DeleteUserResponse> call = retrofitInitializer.userService().freshDatabase();
        try {
            call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deveFalharAoInformarEmailJaExistente() {

        criarUsuarioInicial();

        Espresso.onView(ViewMatchers.withId(R.id.buttonCriarConta)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.textInputEdNome)).perform(ViewActions.replaceText("Davi"));
        Espresso.onView(ViewMatchers.withId(R.id.textInputEdEmail)).perform(ViewActions.replaceText("davi@email.com"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPassword)).perform(ViewActions.replaceText("teste1234"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPasswordConfirm)).perform(ViewActions.replaceText("teste1234"));

        Espresso.onView(ViewMatchers.withId(R.id.buttonCreateAccount)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.textViewMeusDecks))
                .check(ViewAssertions.doesNotExist());

        RetrofitInitializer retrofitInitializer = new RetrofitInitializer();

        Call<DeleteUserResponse> call = retrofitInitializer.userService().freshDatabase();
        try {
            call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void criarUsuarioInicial() {

        PostUserRequest postUserRequest = new PostUserRequest();

        postUserRequest.setName("Cauê");
        postUserRequest.setEmail("davi@email.com");
        postUserRequest.setPassword("teste1234");
        postUserRequest.setPassword_confirmation("teste1234");

        RetrofitInitializer retrofitInitializer = new RetrofitInitializer();
        Call<PostUserResponse> call = retrofitInitializer.userService().postUser(postUserRequest);
        try {
            call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deveCriarUsuario() {

        Espresso.onView(ViewMatchers.withId(R.id.buttonCriarConta)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.textInputEdNome)).perform(ViewActions.replaceText("caue"));
        Espresso.onView(ViewMatchers.withId(R.id.textInputEdEmail)).perform(ViewActions.replaceText("davi@email.com"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPassword)).perform(ViewActions.replaceText("teste1234"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPasswordConfirm)).perform(ViewActions.replaceText("teste1234"));

        Espresso.onView(ViewMatchers.withId(R.id.buttonCreateAccount)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.fragmentHome))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        RetrofitInitializer retrofitInitializer = new RetrofitInitializer();

        Call<DeleteUserResponse> call = retrofitInitializer.userService().freshDatabase();
        try {
            call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}