package com.hexad.interview.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseResponse {
    private static final String ERROR_MSG = "For this number we don't have any combination of packs.";
    private Map<Integer, List<Pack>> packMap = new HashMap<>();
    private BakeryProduct product;
    private int quantity;
    private double total;
    private boolean isFound;

    public boolean isFound() { 
        return isFound; 
    }

    public void setFound(boolean found) { 
        isFound = found; 
    }

    public BakeryProduct getProduct() {
        return product;
    }

    public Map<Integer, List<Pack>> getPackMap() {
        return packMap;
    }

    public void setPackMap(Map<Integer, List<Pack>> packMap) {
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
        
        if(!isFound()) return sb.append("\n\t\t").append(ERROR_MSG).toString();

        for(Map.Entry<Integer, List<Pack>> packEntry: packMap.entrySet()) {
            sb.append("\n\t\t");
            sb.append(packEntry.getValue().size()).append(" x ");
            Pack p = packEntry.getValue().stream().findFirst().get();
            sb.append(p.getQuantity()).append(" $").append(p.getPrice());
        }
        return sb.toString();
    }
}
