package com.hexad.interview.model;

public enum BakeryProductCodeLabel {
    BLUEBERRY_MUFFIN("MB11", "Blueberry Muffin"),
    CROISSANT("CF", "Croissant"),
    VEGEMITE_SCROLL("VS5", "Vegemite Scroll");

    public final String code;
    public final String label;

    BakeryProductCodeLabel(String code, String label) {
        this.code = code;
        this.label = label;
    }
}
