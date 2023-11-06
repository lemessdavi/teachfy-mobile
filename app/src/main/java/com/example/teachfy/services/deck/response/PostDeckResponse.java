package com.example.teachfy.services.deck.response;

import com.example.teachfy.models.Deck;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostDeckResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Deck deck;

    public Deck getDeck() {
        return deck;
    }
}
