package com.example.teachfy;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.teachfy.services.review.response.GetAllFromDeckResponse;
import com.example.teachfy.services.user.request.PostUserRequest;
import com.example.teachfy.services.user.response.DeleteUserResponse;
import com.example.teachfy.services.user.response.PostUserResponse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import retrofit2.Call;

@RunWith(AndroidJUnit4.class)
public class DeckTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void deveCriarDeck() {

        criarUsuarioInicial();

        Espresso.onView(ViewMatchers.withId(R.id.textInputEmailLogin)).perform(ViewActions.replaceText("davi@email.com"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextPasswordLogin)).perform(ViewActions.replaceText("teste1234"));

        Espresso.onView(ViewMatchers.withId(R.id.buttonLogin)).perform(ViewActions.click());

        //clicar no botão de newDeck
        Espresso.onView(ViewMatchers.withId(R.id.navigation_add)).perform(ViewActions.click());

        //seleciona anki
        Espresso.onView(ViewMatchers.withId(R.id.optionAnki)).perform(ViewActions.click());

        //informar dados do deck
        Espresso.onView(ViewMatchers.withId(R.id.textInputTituloAnki)).perform(ViewActions.replaceText("Números Complexos"));
        Espresso.onView(ViewMatchers.withId(R.id.textInputDescricaoAnki)).perform(ViewActions.replaceText("Matemática 3º Ano"));
        Espresso.onView(ViewMatchers.withId(R.id.checkBoxDeckPublicoAnki)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.checkBoxDeckDuplicavel)).perform(ViewActions.click());

        //clicar em criar deck
        Espresso.onView(ViewMatchers.withId(R.id.buttonCriarDeckAnki)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonManualCreation)).perform(ViewActions.click());

        //verificar se deck existe
        Espresso.onView(ViewMatchers.withId(R.id.frameLayout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        //Limpar banco
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

        postUserRequest.setName("davilemes");
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
}
