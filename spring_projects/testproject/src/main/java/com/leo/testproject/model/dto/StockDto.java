package com.leo.testproject.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StockDto {

    private Long id;
    private String name;
    private BigDecimal value;
    private BigDecimal variancia;
    private LocalDateTime data;

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

    public BigDecimal getVariancia() {
        return variancia;
    }

    public void setVariancia(BigDecimal variancia) {
        this.variancia = variancia;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
