package ru.intelinvest.career.models;

import lombok.Data;

import java.util.List;

@Data
public class PageOfStocks {
    List<Stock> stockList;
    int currentNumberPage;
    int limit;
    int countPages;
    int countAllStocks;

    public PageOfStocks(List<Stock> stockList, int currentNumberPage, int limit, int countPages, int countAllStocks) {
        this.stockList = stockList;
        this.currentNumberPage = currentNumberPage;
        this.limit = limit;
        this.countPages = countPages;
        this.countAllStocks = countAllStocks;
    }
}
