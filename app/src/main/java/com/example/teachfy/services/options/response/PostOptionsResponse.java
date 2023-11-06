package com.example.teachfy.services.options.response;

import com.example.teachfy.models.Option;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostOptionsResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Option option;

    public Option getOption() {
        return option;
    }
}
