package com.grm.dds.domain.clothe;

import com.grm.dds.domain.clothe.state.ClotheState;
import com.grm.dds.domain.clothe.state.PriceCalculationStrategy;

public class BaseClothe implements Clothe {

    private float price;
    private ClotheState state;

    public BaseClothe(float price, ClotheState state) {
        this.price = price;
        this.state = state;
    }

    public float getClothePrice() {
        return this.price;
    }

    public float getSalePrice() {
        return PriceCalculationStrategy.get(this.state).calculate(this.price);
    }

    public ClotheState state() throws Exception {
        if (this.state == null) {
            throw new Exception("Missing clothe state"); // TODO: custom exception
        }
        return this.state;
    }

}
