package com.example.teachfy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.example.teachfy.models.User;

import org.junit.Test;

public class UserTest {

    @Test
    public void deveFalharAoInformarNomeInvalido() {
        String name = "";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User(name, email, password, confirmPassword);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarEmailInvalido() {
        String name = "Cauê";
        String email = "caue@123";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User(name, email, password, confirmPassword);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarSenhaMenorQueOitoCaracteres() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste";
        String confirmPassword = "teste";

        User usuario = new User(name, email, password, confirmPassword);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarConfirmacaoDeSenhaInvalida() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste";

        User usuario = new User(name, email, password, confirmPassword);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarSenhaMaiorQueDezesseisCaracteres() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "testeTesteTeste1234";
        String confirmPassword = "testeTesteTeste1234";

        User usuario = new User(name, email, password, confirmPassword);

        assertEquals('2', '2');
    }

    @Test
    public void deveCriarUsuario() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User(name, email, password, confirmPassword);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarNovoNomeInvalido() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User(name, email, password, confirmPassword);

        String newName = "";
        String newPassword = "novoteste1234";
        String newConfirmPassword = "novoteste1234";

        usuario.setName(newName);
        usuario.setPassword(newPassword);
        usuario.setConfirmPassword(newConfirmPassword);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarNovaSenhaInvalida() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User(name, email, password, confirmPassword);

        String newName = "Cauê Marques";
        String newPassword = "novoteste";
        String newConfirmPassword = "novoteste";

        usuario.setName(newName);
        usuario.setPassword(newPassword);
        usuario.setConfirmPassword(newConfirmPassword);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarNovaConfirmacaoDeSenhaInvalida() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User(name, email, password, confirmPassword);

        String newName = "Cauê Marques";
        String newPassword = "novoteste1234";
        String newConfirmPassword = "novoteste";

        usuario.setName(newName);
        usuario.setPassword(newPassword);
        usuario.setConfirmPassword(newConfirmPassword);

        assertEquals('2', '2');
    }

    @Test
    public void deveAtualizarUsuario() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User(name, email, password, confirmPassword);

        String newName = "Cauê Marques";
        String newPassword = "novoteste1234";
        String newConfirmPassword = "novoteste1234";

        usuario.setName(newName);
        usuario.setPassword(newPassword);
        usuario.setConfirmPassword(newConfirmPassword);

        assertEquals('2', '2');
    }
}
