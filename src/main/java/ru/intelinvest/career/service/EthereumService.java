package ru.intelinvest.career.service;


import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.intelinvest.career.models.BalanceOfTokens;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class EthereumService {
    private final RestTemplate restTemplate;

    public BigDecimal getBalance() {
        return getBalanceOfTokens().getBalance();
    }

    public BalanceOfTokens getBalanceOfTokens() {
        ResponseEntity<BalanceOfTokens> responseEntity =
                restTemplate.exchange(
                        "https://api.etherscan.io/api?" +
                                "module=account" +
                                "&action=tokenbalance" +
                                "&contractaddress=0x77DDc987516abd90803b7e2A18F0F53a98438362" +
                                "&address=0x77DDc987516abd90803b7e2A18F0F53a98438362" +
                                "&tag=latest" +
                                "&apikey=R7F8F1YQXEENJE8WZM6HH3AT24UIK35VCM",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );
        return responseEntity.getBody();
    }
}
