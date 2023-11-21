package com.example.teachfy.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;


import com.example.teachfy.exceptions.UserException;
import com.example.teachfy.models.User;

import org.junit.Test;

public class CreateUserTest {

    @Test
    public void deveFalharAoInformarNomeInvalido() {
        String name = "";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User();

        assertThrows(UserException.class, () -> {
            usuario.setName(name);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setConfirmPassword(confirmPassword);
        });
    }

    @Test
    public void deveFalharAoInformarEmailInvalido() {
        String name = "Cauê";
        String email = "caue@123";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User();

        assertThrows(UserException.class, () -> {
            usuario.setName(name);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setConfirmPassword(confirmPassword);
        });
    }

    @Test
    public void deveFalharAoInformarSenhaMenorQueOitoCaracteres() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste";
        String confirmPassword = "teste";

        User usuario = new User();

        assertThrows(UserException.class, () -> {
            usuario.setName(name);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setConfirmPassword(confirmPassword);
        });
    }

    @Test
    public void deveFalharAoInformarConfirmacaoDeSenhaInvalida() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste";

        User usuario = new User();

        assertThrows(UserException.class, () -> {
            usuario.setName(name);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setConfirmPassword(confirmPassword);
        });
    }

    @Test
    public void deveFalharAoInformarSenhaMaiorQueDezesseisCaracteres() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "testeTesteTeste1234";
        String confirmPassword = "testeTesteTeste1234";

        User usuario = new User();

        assertThrows(UserException.class, () -> {
            usuario.setName(name);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setConfirmPassword(confirmPassword);
        });
    }

    @Test
    public void deveCriarUsuario() {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        User usuario = new User();

        try {
            usuario.setName(name);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setConfirmPassword(confirmPassword);
        } catch(UserException e) {
            fail("Falha na criação do Usuário");
        }
    }
}
