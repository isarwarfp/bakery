package com.hexad.interview.repository;

import com.hexad.interview.model.BakeryProduct;
import com.hexad.interview.model.PurchaseResponse;
import com.hexad.interview.service.PriceCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BakeryRepository {
    private Map<String, BakeryProduct> products = new HashMap<>();

    public void addProduct(BakeryProduct product) {
        products.put(product.getCode(), product);
    }

    public List<PurchaseResponse> getCost(String code, int quantity) {
        PriceCalculator calculator = new PriceCalculator();
        List<PurchaseResponse> result = new ArrayList<>();
        products.entrySet().stream().filter(m -> m.getKey().equals(code))
                .forEach(element -> result.add(calculator.calculatePrice(quantity, element.getValue())));
        return result;
    }
}
