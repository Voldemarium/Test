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
import lombok.Data;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonPropertyOrder({   // Порялок полей при сериализации
        "SECID",
        "BOARDID",
        "SHORTNAME",
        "PREVPRICE",
        "LOTSIZE",
        "FACEVALUE",
        "STATUS",
        "BOARDNAME",
        "DECIMALS",
        "SECNAME",
        "REMARKS",
        "MARKETCODE",
        "INSTRID",
        "SECTORID",
        "MINSTEP",
        "PREVWAPRICE",
        "FACEUNIT",
        "PREVDATE",
        "ISSUESIZE",
        "ISIN",
        "LATNAME",
        "REGNUMBER",
        "PREVLEGALCLOSEPRICE",
        "CURRENCYID",
        "SECTYPE",
        "LISTLEVEL",
        "SETTLEDATE"
})
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
    @JsonProperty("PREVDATE")
    private Date prevdate;
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
    @JsonProperty("SETTLEDATE")
    private Date settledate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}




