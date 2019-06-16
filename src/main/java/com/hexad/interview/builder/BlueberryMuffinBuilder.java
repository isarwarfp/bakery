package com.hexad.interview.builder;

import com.hexad.interview.model.BakeryProduct;
import com.hexad.interview.model.Pack;

import java.util.List;

public class BlueberryMuffinBuilder extends BakeryItemBuilder {

    public BlueberryMuffinBuilder(List<Pack> packs) {
        super(packs);
    }

    @Override
    protected BlueberryMuffinBuilder self()
    {
        return this;
    }
}
