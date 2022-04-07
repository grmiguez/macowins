package com.grm.dds.domain.clothe.state;

public class Sale implements ClothePriceCalculation {

    public float calculate(float clothePrice) {
        return clothePrice / 2;
    }

}
