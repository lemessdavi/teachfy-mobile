package com.example.teachfy.services.options.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostOptionRequest {
    private int card_id;
    private String description;
    private boolean correct_answer;

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(boolean correct_answer) {
        this.correct_answer = correct_answer;
    }
}
