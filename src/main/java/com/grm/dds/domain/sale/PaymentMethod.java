package com.grm.dds.domain.sale;

import java.util.List;

public interface PaymentMethod {
    default float calculatePriceToPay(List<Float> prices) {
        return prices.stream().reduce((float) 0, Float::sum);
    }
}
