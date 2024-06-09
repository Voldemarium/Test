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

package ru.intelinvest.career.controller;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.intelinvest.career.models.PageOfStocks;
import ru.intelinvest.career.models.Stock;
import ru.intelinvest.career.service.MoexService;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/moex")
@Slf4j
public class MoexEndpoint {

    private final MoexService moexService;

    @PostMapping("stocks")
    public ResponseEntity<List<Stock>> processIntegration() {
        var stocks = moexService.getStocks();
        // todo реализация задания № 2 и 3 здесь

        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<Object>> getFilteredStocks(@RequestParam(required = false) Integer lotSize,
                                                          @RequestParam(required = false) List<Integer> listLevel,
                                                          @RequestParam(required = false) List<String> secId,
                                                          @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
                                                          @RequestParam(required = false, defaultValue = "3") Integer limit
    ) {
        List<Stock> stocks = moexService.getStocks();
        // Фильтрация данных
        if (lotSize != null) {
            stocks = stocks.stream()
                    .filter(stock -> stock.getLotsize().equals(lotSize))
                    .toList();
        }
        if (listLevel != null) {
            stocks = stocks.stream()
                    .filter(stock -> {
                        for (Integer level : listLevel) {
                            if (stock.getListlevel().equals(level)) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .toList();
        }
        if (secId != null) {
            stocks = stocks.stream()
                    .filter(stock -> {
                        for (String id : secId) {
                            if (Objects.equals(stock.getSecId(), id)) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .toList();
        }
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // Пагинация данных
        if (pageNumber != null && limit != null) {
            int countStocks = stocks.size();
            if (limit < countStocks) {
                List<List<Stock>> pagesOfStocks = Lists.partition(stocks, limit);
                int countPages = pagesOfStocks.size();
                log.info("pageNumber: {}", pageNumber);
                log.info("count pages: {}", countPages);
                log.info("countStocks): {}", countStocks);
                if (pageNumber < 1 || pageNumber > countPages) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                } else {
                    PageOfStocks page = new PageOfStocks(pagesOfStocks.get(pageNumber - 1), pageNumber, limit,
                            countPages, countStocks);
                    return ResponseEntity.ok(Collections.singletonList(page));
                }
            } else {
                return ResponseEntity.ok(Collections.singletonList(stocks));
            }
        } else {
            return ResponseEntity.ok(Collections.singletonList(stocks));
        }
    }
}
