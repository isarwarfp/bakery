package com.hexad.interview.builder;

import com.hexad.interview.model.Pack;
import com.hexad.interview.repository.BakeryRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hexad.interview.model.BakeryProductCodeLabel.*;

public class DataBuilder {
    private static final Map<String, List<Pack>> data;
    static {
        data = new HashMap<>();
        data.put(BLUEBERRY_MUFFIN.code, Arrays.asList(
                new Pack(9.99, 2),
                new Pack(16.95, 5),
                new Pack(24.95, 8)));

        data.put(CROISSANT.code, Arrays.asList(
                new Pack(6.99, 3),
                new Pack(8.99, 5),
                new Pack(16.99, 9)));

        data.put(VEGEMITE_SCROLL.code, Arrays.asList(
                new Pack(6.99, 3),
                new Pack(8.99, 5)
        ));
    }
    public BakeryRepository prepareBakeryData() {
        BakeryRepository cakeRepository = new BakeryRepository();
        cakeRepository.addProduct(new BlueberryMuffinBuilder(data.get(BLUEBERRY_MUFFIN.code))
                .withCode(BLUEBERRY_MUFFIN.code)
                .withName(BLUEBERRY_MUFFIN.label)
                .build());
        cakeRepository.addProduct(new CroissantBuilder(data.get(CROISSANT.code))
                .withCode(CROISSANT.code)
                .withName(CROISSANT.label)
                .build());
        cakeRepository.addProduct(new VegemiteScrollBuilder(data.get(VEGEMITE_SCROLL.code))
                .withCode(VEGEMITE_SCROLL.code)
                .withName(VEGEMITE_SCROLL.label)
                .build());
        return cakeRepository;
    }
}
