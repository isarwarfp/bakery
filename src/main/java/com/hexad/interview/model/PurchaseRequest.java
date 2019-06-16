package com.hexad.interview.model;

public class PurchaseRequest {
    private Integer quantity;
    private String code;

    public PurchaseRequest(Integer quantity, String code) {
        this.quantity = quantity;
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
