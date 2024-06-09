package ru.intelinvest.career;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import ru.intelinvest.career.models.Stock;
import ru.intelinvest.career.service.MoexService;

import java.util.List;

public class TestService {
    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        MoexService moexService = new MoexService(restTemplate);
        List<Stock> stocks = moexService.getStocks();
        log.info("stocks: {}", stocks.size());
    }
}
