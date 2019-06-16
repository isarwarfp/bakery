package com.hexad.interview.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseResponse {
    private String paymentId;
    private Map<String, Map<Integer, List<Pack>>> packMap = new HashMap<>();
    private BakeryProduct product;
    private int quantity;
    private double total;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public BakeryProduct getProduct() {
        return product;
    }

    public Map<String, Map<Integer, List<Pack>>> getPackMap() {
        return packMap;
    }

    public void setPackMap(Map<String, Map<Integer, List<Pack>>> packMap) {
        this.packMap = packMap;
    }

    public void setProduct(BakeryProduct product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return toStringImpl();
    }

    private String toStringImpl() {
        StringBuilder sb = new StringBuilder();
        sb.append(quantity).append(" ").append(product.getCode()).append(" $").append(total);

        for(Map.Entry<String, Map<Integer, List<Pack>>> packEntry: packMap.entrySet()) {
            for(Map.Entry<Integer, List<Pack>> packQtyEntry: packEntry.getValue().entrySet()) {
                sb.append("\n\t\t");
                sb.append(packQtyEntry.getValue().size()).append(" x ");
                Pack p = packQtyEntry.getValue().stream().findFirst().get();
                sb.append(p.getQuantity()).append(" $").append(p.getPrice());
            }
        }
        return sb.toString();
    }
}
