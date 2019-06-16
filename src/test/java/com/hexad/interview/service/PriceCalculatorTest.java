package com.hexad.interview.service;

import com.hexad.interview.model.PurchaseRequest;
import com.hexad.interview.model.PurchaseResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PriceCalculatorTest {

    private PurchaseService service;
    private Map<String, List<PurchaseResponse>> response;
    private static final String PRODUCT_CODE = "VS5";
    @Before
    public void prepareData() {
        service = new PurchaseService();
        PurchaseRequest request = new PurchaseRequest(10, PRODUCT_CODE);
        response = service.placeOrder(Arrays.asList(new PurchaseRequest[]{request}));
    }

    @Test
    public void checkProductCodeInResponse() {
        Assert.assertTrue("Requested Product code is not found as key in the response.", response.containsKey("VS5"));
    }

    @Test
    public void checkTotalSumCorrect() {
        List<PurchaseResponse> responseList = response.get("VS5");
        Assert.assertEquals("Total sum is not correct.", 17.98, responseList.get(0).getTotal(), 0.0);
    }

    @Test
    public void solutionWithMinimum() {
        List<PurchaseResponse> responseList = response.get("VS5");
        Assert.assertEquals("Total Number of Products incorrect.", 10, responseList.get(0).getQuantity());
        responseList.stream().forEach(x-> {
            Assert.assertEquals("Pack are not with minimum number.", 2, x.getPackMap().get(5).size());
        });
    }
}
