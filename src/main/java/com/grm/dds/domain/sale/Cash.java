package com.grm.dds.domain.sale;

import java.util.List;

public class Cash implements PaymentMethod {

    @Override
    public float calculatePriceToPay(List<Float> prices) {
        return PaymentMethod.super.calculatePriceToPay(prices);
    }
}
