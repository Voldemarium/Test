package ru.intelinvest.career.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class BalanceOfTokens {
    @JsonProperty("status")
    Integer status;
    @JsonProperty("message")
    String message;
    @JsonProperty("result")
    BigInteger balance;

    public BigDecimal getBalance() {
        return new BigDecimal(balance, 18);
    }

}
