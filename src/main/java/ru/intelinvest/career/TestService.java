package ru.intelinvest.career;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import ru.intelinvest.career.models.Stock;
import ru.intelinvest.career.service.EthereumService;
import ru.intelinvest.career.service.MoexService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class TestService {
    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        EthereumService ethereumService = new EthereumService(restTemplate);
        log.info("balance: {}" , ethereumService.getBalance());
        String s = "987123456789123456789";
        BigDecimal bigDecimal = new BigDecimal(new BigInteger(s), 18);
        log.info("bigDecimal : {}", bigDecimal);
    }
}
