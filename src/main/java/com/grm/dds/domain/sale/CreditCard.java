package com.grm.dds.domain.sale;

import java.util.List;

public class CreditCard implements PaymentMethod {

    private final float FIXEDVALUE = 5;
    private final float ITEMSPERCENTAGE = (float) 0.1;
    private final int installments;

    public CreditCard(int installments) {
        this.installments = installments;
    }

    @Override
    public float calculatePriceToPay(List<Float> prices) {
        return (this.installments * FIXEDVALUE + itemsPriceSum(prices, ITEMSPERCENTAGE));
    }

    private float itemsPriceSum(List<Float> prices, float percentage) {
        return prices.stream().reduce((float) 0, (origin, price) -> origin + (percentage * price));
    }
}
