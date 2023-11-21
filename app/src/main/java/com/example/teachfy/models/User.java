package com.example.teachfy.models;

import com.example.teachfy.exceptions.UserException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private static String logedToken;
    private String token;
    private String name;
    private String email;

    private String password;

    private String confirmPassword;

    private int id;

    public User() {}

    public User(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public static void logarUsuario(String rawToken){
        logedToken = "Bearer " + rawToken;
    }

    public static String getLogedToken(){
        return logedToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UserException {
        if(name.isBlank()) {
            throw new UserException("Nome inválido");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws UserException {

        if(email.isBlank() || !email.contains("@") || !email.contains(".com")) {
            throw new UserException("Email inválido");
        }

        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws UserException {

        if(password.length() < 8) {
            throw new UserException("Senha menor que 8 caracteres");
        }

        if(password.length() > 16) {
            throw new UserException("Senha maior que 16 caracteres");
        }

        if(!password.matches("^[a-zA-Z0-9]+$")) {
            throw new UserException("A senha deve conter letras e números");
        }

        if(password.isBlank()) {
            throw new UserException("Senha inválida");
        }
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) throws UserException {
        if(confirmPassword.isBlank()) {
            throw new UserException("As senhas não coincidem");
        }

        if(!confirmPassword.equals(this.password)) {
            throw new UserException("As senhas não coincidem");
        }

        this.confirmPassword = confirmPassword;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
