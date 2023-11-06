package com.example.teachfy.services.card.response;

import com.example.teachfy.models.Card;
import com.example.teachfy.services.card.CardDataPOJO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCardsResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private CardDataPOJO data;

    public List<Card> getDeckRequests() {
        return data.getCards();
    }
}
