package com.example.teachfy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
    private int id;
    private int deck_id;
    private int deck_type;
    private int type;
    private String question;
    private String answer;
    private Double points;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(int deck_id) {
        this.deck_id = deck_id;
    }

    public int getDeck_type() {
        return deck_type;
    }

    public void setDeck_type(int deck_type) {
        this.deck_type = deck_type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }
}
