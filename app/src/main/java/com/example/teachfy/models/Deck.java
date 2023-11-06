package com.example.teachfy.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Deck {
    private int id;
    private int user_id;
    private Integer folder_id;
    private String name;
    @JsonProperty("public")
    private int publicDeck;
    private int clonable;
    private int feedback;
    @JsonProperty("type")
    private int type;
    private String created_at;
    private String updated_at;
    private String description;
    @JsonIgnore
    private String qntdCards;
    @JsonIgnore
    private String porcentagemAcerto;

    public Deck() {

    }

    public Deck(String porcentagemAcerto, String name, String qntdCards) {
        this.name = name;
        this.qntdCards = qntdCards;
        this.porcentagemAcerto = porcentagemAcerto;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Integer getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(Integer folder_id) {
        this.folder_id = folder_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicDeck() {
        return publicDeck;
    }

    @JsonIgnore
    public void setPublicDeck(int publicDeck) {
        this.publicDeck = publicDeck;
    }

    public void setPublicDeck(boolean publicDeck) {
        if(publicDeck)
            this.publicDeck = 1;
        else
            this.publicDeck = 0;
    }

    public int getClonable() {
        return clonable;
    }

    public void setClonable(int clonable) {
        this.clonable = clonable;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQntdCards() {
        return qntdCards;
    }

    public void setQntdCards(String qntdCards) {
        this.qntdCards = qntdCards;
    }

    public String getPorcentagemAcerto() {
        return porcentagemAcerto;
    }

    public void setPorcentagemAcerto(String porcentagemAcerto) {
        this.porcentagemAcerto = porcentagemAcerto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
