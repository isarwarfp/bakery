package com.hexad.interview.model;

import java.util.List;

public class BakeryProduct {
    private List<Pack> packs;
    private String code;
    private String name;

    public BakeryProduct(List<Pack> packs) {
        this.packs = packs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pack> getPacks() {
        return packs;
    }
}
