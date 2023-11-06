package com.example.teachfy.services.card;

import com.example.teachfy.models.Card;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDataPOJO {

    @JsonProperty("data")
    List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }
}
