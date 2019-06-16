package com.hexad.interview.service;

import com.hexad.interview.builder.DataBuilder;
import com.hexad.interview.model.PurchaseRequest;
import com.hexad.interview.model.PurchaseResponse;
import com.hexad.interview.repository.BakeryRepository;

import java.util.ArrayList;
import java.util.List;

public class PurchaseService {
    public void placeOrder(List<PurchaseRequest> orders) {
        BakeryRepository bakeryRepository = init();

        StringBuilder sb = new StringBuilder();
        for(PurchaseRequest order: orders) {
            sb.append("Orders are:\n");
            sb.append(order.getQuantity()).append(" ").append(order.getCode()).append("\n");
        }
        for (PurchaseRequest order : orders) {
            bakeryRepository.getCost(order.getCode(), order.getQuantity())
                    .stream().forEach(System.out::println);
        }
    }

    public BakeryRepository init() {
        DataBuilder dataBuilder = new DataBuilder();
        return dataBuilder.prepareBakeryData();
    }
}
