package com.hexad.interview.service;

import com.hexad.interview.builder.DataBuilder;
import com.hexad.interview.model.PurchaseRequest;
import com.hexad.interview.model.PurchaseResponse;
import com.hexad.interview.repository.BakeryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseService {
    public Map<String, List<PurchaseResponse>> placeOrder(List<PurchaseRequest> orders) {
        Map<String, List<PurchaseResponse>> response = new HashMap<>();
        BakeryRepository bakeryRepository = init();
        for (PurchaseRequest order : orders) {
            response.put(order.getCode(), bakeryRepository.getCost(order.getCode(), order.getQuantity()));
        }
        return response;
    }

    public BakeryRepository init() {
        DataBuilder dataBuilder = new DataBuilder();
        return dataBuilder.prepareBakeryData();
    }
}
