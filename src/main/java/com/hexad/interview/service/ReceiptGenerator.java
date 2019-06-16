package com.hexad.interview.service;

import com.hexad.interview.model.PurchaseRequest;
import com.hexad.interview.model.PurchaseResponse;

import java.util.List;
import java.util.Map;

public class ReceiptGenerator {

    public void generateOrderReceipt(List<PurchaseRequest> orders, Map<String, List<PurchaseResponse>> response) {
        generateRequestSection(orders);
        generateResponseSection(response);
    }

    private void generateRequestSection(List<PurchaseRequest> orders){
        StringBuilder sb = new StringBuilder("Orders are:\n");
        for(PurchaseRequest order: orders) {
            sb.append(order.getQuantity()).append(" ").append(order.getCode()).append("\n");
        }
        System.out.println(sb.toString());
    }
    private void generateResponseSection(Map<String, List<PurchaseResponse>> response) {
        for(Map.Entry<String, List<PurchaseResponse>> entry: response.entrySet()) {
            entry.getValue().stream().forEach(System.out::println);
        }
    }
}
