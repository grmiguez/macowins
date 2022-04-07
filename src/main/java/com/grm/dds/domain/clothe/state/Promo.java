package com.grm.dds.domain.clothe.state;

public class Promo implements ClothePriceCalculation {
    // TODO: config? debería poder configurarlo el user
    private final float fixedDiscountValue = 10;

    public float calculate(float clothePrice) {
        return clothePrice - this.fixedDiscountValue;
    }
}
