package ru.intelinvest.career.models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ParsingStocks {
    @JsonProperty("securities")
    private List<Stock> securities;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

}
