package com.hexad.interview.builder;

import com.hexad.interview.model.BakeryProduct;
import com.hexad.interview.model.Pack;

import java.util.List;

public class CroissantBuilder extends BakeryItemBuilder<CroissantBuilder> {

    public CroissantBuilder(List<Pack> packs) {
        super(packs);
    }

    @Override
    protected CroissantBuilder self()
    {
        return this;
    }
}
