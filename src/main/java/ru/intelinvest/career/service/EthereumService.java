package ru.intelinvest.career.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.intelinvest.career.models.BalanceOfTokens;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class EthereumService {
    private final RestTemplate restTemplate;
    @Value("${ethereum.apikey}")
    String apikey;
    @Value("${ethereum.address}")
    String address;

    public Double getBalance() {
        return getBalanceOfTokens().getBalance();
    }

    public BalanceOfTokens getBalanceOfTokens() {
        ResponseEntity<BalanceOfTokens> responseEntity =
                restTemplate.exchange(
                        "https://api.etherscan.io/api?" +
                                "module=account" +
                                "&action=tokenbalance" +
                                "&contractaddress=" + address +
                                "&address=" + address +
                                "&tag=latest" +
                                "&apikey=" + apikey,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );
        return responseEntity.getBody();
    }
}
