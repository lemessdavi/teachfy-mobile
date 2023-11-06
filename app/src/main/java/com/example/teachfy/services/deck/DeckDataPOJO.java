package com.example.teachfy.services.deck;

import com.example.teachfy.models.Deck;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeckDataPOJO {
    @JsonProperty("data")
    List<Deck> decks;

    public List<Deck> getDecks() {
        return decks;
    }
}
