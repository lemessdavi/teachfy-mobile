package com.example.teachfy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Option {

    private int id;
    private int card_id;
    private String description;
    private boolean correct_answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


//            "id": 1,
//            "card_id": 1,
//            "description": "opt1",
//            "correct_answer": 1,
//            "created_at": "2023-10-29T00:26:50.000000Z",
//            "updated_at": "2023-10-29T00:26:50.000000Z"
