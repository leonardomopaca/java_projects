package com.leo.teste.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StockDto {
    private Long id;
    private String name;
    private BigDecimal value;
    private BigDecimal variaty;
    private LocalDateTime date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getVariaty() {
        return variaty;
    }

    public void setVariaty(BigDecimal variaty) {
        this.variaty = variaty;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
