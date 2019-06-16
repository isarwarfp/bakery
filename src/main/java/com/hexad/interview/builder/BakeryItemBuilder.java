package com.hexad.interview.builder;

import com.hexad.interview.model.BakeryProduct;
import com.hexad.interview.model.Pack;

import java.util.List;

public class BakeryItemBuilder<SELF extends BakeryItemBuilder<SELF>> {
    protected BakeryProduct item;

    public BakeryItemBuilder(List<Pack> packs) {
        item = new BakeryProduct(packs);
    }

    public SELF withCode(String code) {
        item.setCode(code);
        return self();
    }

    public SELF withName(String name) {
        item.setName(name);
        return self();
    }

    protected SELF self()
    {
        // unchecked cast, but actually safe
        // proof: try sticking a non-PersonBuilder
        //        as SELF parameter; it won't work!
        return (SELF) this;
    }

    public BakeryProduct build()
    {
        return item;
    }
}
