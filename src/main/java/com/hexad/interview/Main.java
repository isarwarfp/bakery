package com.hexad.interview;

import com.hexad.interview.model.PurchaseRequest;
import com.hexad.interview.service.PurchaseService;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PurchaseService service = new PurchaseService();
        List<PurchaseRequest> requests = Arrays.asList(new PurchaseRequest[] {
                new PurchaseRequest(10, "VS5"),
                new PurchaseRequest(14, "MB11"),
                new PurchaseRequest(13, "CF")});
        service.placeOrder(requests);

    }
}
