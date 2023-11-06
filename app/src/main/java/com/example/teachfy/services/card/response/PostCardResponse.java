package com.example.teachfy.services.card.response;

import com.example.teachfy.models.Card;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCardResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Card card;

    public Card getCard() {
        return card;
    }

}
