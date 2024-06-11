package ru.intelinvest.career.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageOfStocks {
    List<Stock> stockList;
    int currentNumberPage;
    int limit;
    int countPages;
    int countAllStocks;
}
