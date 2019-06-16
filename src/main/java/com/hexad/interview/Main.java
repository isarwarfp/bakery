package com.hexad.interview;

import com.hexad.interview.model.PurchaseRequest;
import com.hexad.interview.model.PurchaseResponse;
import com.hexad.interview.service.PurchaseService;
import com.hexad.interview.service.ReceiptGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        PurchaseService service = new PurchaseService();
        ReceiptGenerator generator = new ReceiptGenerator();
        List<PurchaseRequest> requests = Arrays.asList(new PurchaseRequest[] {
                new PurchaseRequest(10, "VS5"),
                new PurchaseRequest(14, "MB11"),
                new PurchaseRequest(13, "CF")});
        Map<String, List<PurchaseResponse>> response = service.placeOrder(requests);
        generator.generateOrderReceipt(requests, response);
    }
}
