package com.hexad.interview.service;

import com.hexad.interview.model.BakeryProduct;
import com.hexad.interview.model.Pack;
import com.hexad.interview.model.PurchaseResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class PriceCalculator {
    private int minPack = Integer.MAX_VALUE;
    private Stack<Pack> stack = new Stack<>();
    PurchaseResponse response = new PurchaseResponse();
    boolean foundSolution;

    public PurchaseResponse calculatePrice(int number, BakeryProduct product) {
        List<Pack> packs = product.getPacks();
        double cost = 0.0;
        packs.sort((o1, o2) -> o1.getQuantity() < o2.getQuantity() ? 1 : -1);
        calculateMinPack(0, number, packs);
        while(!stack.isEmpty()) {
            Pack pack = stack.pop();
            Map<String, Map<Integer, List<Pack>>> map = response.getPackMap();
            if(!map.containsKey(product.getCode())) {
                map.put(product.getCode(), new HashMap<>());
            }
            if(!map.get(product.getCode()).containsKey(pack.getQuantity())) {
                map.get(product.getCode()).put(pack.getQuantity(), new ArrayList<>());
            }
            map.get(product.getCode()).get(pack.getQuantity()).add(pack);
            cost += pack.getPrice();
            cost = round(cost, 2);
        }

        response.setProduct(product);
        response.setTotal(cost);
        return response;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void calculateMinPack(int count, int total, List<Pack> packs) {
        if (total == 0) {
            if (count < minPack) {
                minPack = count;
                foundSolution = true;
            }
            return;
        }
        if (total < 0) {
            return;
        }

        for (Pack pack : packs) {
            if (pack.getQuantity() <= total) {
                if (foundSolution) return;
                stack.push(pack);
                calculateMinPack(count+1, total - pack.getQuantity(), packs);
            }
        }
        if (foundSolution) return;
        stack.pop();
    }
}
