package com.example.teachfy.services.deck.response;

import com.example.teachfy.models.Deck;
import com.example.teachfy.services.deck.DeckDataPOJO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDecksResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private DeckDataPOJO data;

    public List<Deck> getDeckRequests() {
        return data.getDecks();
    }
}
