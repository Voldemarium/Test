/*
 * STRICTLY CONFIDENTIAL
 * TRADE SECRET
 * PROPRIETARY:
 *       "Intelinvest" Ltd, TIN 1655386205
 *       420107, REPUBLIC OF TATARSTAN, KAZAN CITY, SPARTAKOVSKAYA STREET, HOUSE 2, ROOM 119
 * (c) "Intelinvest" Ltd, 2019
 *
 * СТРОГО КОНФИДЕНЦИАЛЬНО
 * КОММЕРЧЕСКАЯ ТАЙНА
 * СОБСТВЕННИК:
 *       ООО "Интеллектуальные инвестиции", ИНН 1655386205
 *       420107, РЕСПУБЛИКА ТАТАРСТАН, ГОРОД КАЗАНЬ, УЛИЦА СПАРТАКОВСКАЯ, ДОМ 2, ПОМЕЩЕНИЕ 119
 * (c) ООО "Интеллектуальные инвестиции", 2019
 */

package ru.intelinvest.career.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.intelinvest.career.models.ParsingStocks;
import ru.intelinvest.career.models.Stock;


import java.util.*;

@Service
@RequiredArgsConstructor
public class MoexService {
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    @Cacheable(value = "stock")
    public List<Stock> getStocks() {
        // todo реализация задания № 1 здесь
        ResponseEntity<LinkedHashMap<String, Object>[]> responseEntity =
                restTemplate.exchange(
                        "https://iss.moex.com/iss/engines/stock/markets/shares/boards/TQBR/securities/.json" +
                                "?iss.meta=off&iss.only=securities&iss.json=extended",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );
        LinkedHashMap<String, Object>[] objectsOfBody = responseEntity.getBody();
        List<Stock> stocks = new ArrayList<>();
        assert objectsOfBody != null;
        for (LinkedHashMap<String, Object> object : objectsOfBody) {
            if (object.containsKey("securities")) {
                stocks = mapper.convertValue(object, ParsingStocks.class).getSecurities();
            }
        }
        return stocks;
    }



}
