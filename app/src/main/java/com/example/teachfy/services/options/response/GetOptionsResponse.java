package com.example.teachfy.services.options.response;

import com.example.teachfy.models.Option;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOptionsResponse {

    private String message;

    @JsonProperty("data")
    private List<Option> options;

    public List<Option> getOptions() {
        return options;
    }
}
