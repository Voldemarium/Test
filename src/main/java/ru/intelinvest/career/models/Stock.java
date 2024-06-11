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

package ru.intelinvest.career.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Stock {
    @JsonProperty("SECID")
    private String secId;
    @JsonProperty("BOARDID")
    private String boardid;
    @JsonProperty("SHORTNAME")
    private String shortname;
    @JsonProperty("PREVPRICE")
    private Double prevprice;
    @JsonProperty("LOTSIZE")
    private Integer lotsize;
    @JsonProperty("FACEVALUE")
    private Double facevalue;
    @JsonProperty("STATUS")
    private String status;
    @JsonProperty("BOARDNAME")
    private String boardname;
    @JsonProperty("DECIMALS")
    private Integer decimals;
    @JsonProperty("SECNAME")
    private String secname;
    @JsonProperty("REMARKS")
    private String remarks;
    @JsonProperty("MARKETCODE")
    private String marketcode;
    @JsonProperty("INSTRID")
    private String instrid;
    @JsonProperty("SECTORID")
    private String sectorid;
    @JsonProperty("MINSTEP")
    private Double minstep;
    @JsonProperty("PREVWAPRICE")
    private Double prevwaprice;
    @JsonProperty("FACEUNIT")
    private String faceunit;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("PREVDATE")
    private LocalDate prevdate;
    @JsonProperty("ISSUESIZE")
    private Long issuesize;
    @JsonProperty("ISIN")
    private String isin;
    @JsonProperty("LATNAME")
    private String latname;
    @JsonProperty("REGNUMBER")
    private String regnumber;
    @JsonProperty("PREVLEGALCLOSEPRICE")
    private Double prevlegalcloseprice;
    @JsonProperty("CURRENCYID")
    private String currencyid;
    @JsonProperty("SECTYPE")
    private String sectype;
    @JsonProperty("LISTLEVEL")
    private Integer listlevel;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("SETTLEDATE")
    private LocalDate settledate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

}




