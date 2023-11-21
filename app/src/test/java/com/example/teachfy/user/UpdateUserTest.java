package com.example.teachfy.user;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.example.teachfy.exceptions.UserException;
import com.example.teachfy.models.User;

import org.junit.Before;
import org.junit.Test;

public class UpdateUserTest {

    User user;

    @Before
    public void initUser() throws UserException {
        String name = "Cauê";
        String email = "caue@gmail.com";
        String password = "teste1234";
        String confirmPassword = "teste1234";

        user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);
    }

    @Test
    public void deveFalharAoInformarNovoNomeInvalido() {
        String newName = "";
        String newPassword = "novoteste1234";
        String newConfirmPassword = "novoteste1234";

        assertThrows(UserException.class, () -> {
            user.setName(newName);
            user.setPassword(newPassword);
            user.setConfirmPassword(newConfirmPassword);
        });
    }

    @Test
    public void deveFalharAoInformarNovaSenhaInvalida() {
        String newName = "Cauê Marques";
        String newPassword = "novoteste";
        String newConfirmPassword = "novoteste";

        assertThrows(UserException.class, () -> {
            user.setName(newName);
            user.setPassword(newPassword);
            user.setConfirmPassword(newConfirmPassword);
        });
    }

    @Test
    public void deveFalharAoInformarNovaConfirmacaoDeSenhaInvalida() {
        String newName = "Cauê Marques";
        String newPassword = "novoteste1234";
        String newConfirmPassword = "novoteste";

        assertThrows(UserException.class, () -> {
            user.setName(newName);
            user.setPassword(newPassword);
            user.setConfirmPassword(newConfirmPassword);
        });
    }

    @Test
    public void deveAtualizarUsuario() {
        String newName = "Cauê Marques";
        String newPassword = "novoteste1234";
        String newConfirmPassword = "novoteste1234";

        try {
            user.setName(newName);
            user.setPassword(newPassword);
            user.setConfirmPassword(newConfirmPassword);
        } catch (UserException e) {
            fail("Falha na criação do Usuário");
        }
    }
}
