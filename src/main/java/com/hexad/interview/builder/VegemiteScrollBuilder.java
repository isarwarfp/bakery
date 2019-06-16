package com.hexad.interview.builder;

import com.hexad.interview.model.Pack;

import java.util.List;

public class VegemiteScrollBuilder extends BakeryItemBuilder {

    public VegemiteScrollBuilder(List<Pack> packs) {
        super(packs);
    }

    @Override
    protected VegemiteScrollBuilder self()
    {
        return this;
    }
}
