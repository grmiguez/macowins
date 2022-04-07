package com.grm.dds.tests.java.mothers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import com.grm.dds.domain.sale.CreditCard;
import com.grm.dds.domain.sale.Cash;
import com.grm.dds.domain.sale.Sale;

public class SaleMother {

    public static Sale saleOfOnePromoShirtPaidWithCash() {

        return new Sale(
                new ArrayList<>(Arrays.asList(ClotheMother.promoShirt())),
                new Cash());
    }

    public static Sale saleOfOnePromoShirtPaidWithCreditCard(int installments) {

        return new Sale(
                new ArrayList<>(Arrays.asList(ClotheMother.promoShirt())),
                new CreditCard(installments));
    }

    public static Sale saleOfMultipleItemsPaidWithCash() {

        return new Sale(
                new ArrayList<>(Arrays.asList(ClotheMother.promoShirt(), ClotheMother.newCoat())),
                new Cash());
    }

    public static Sale fromAmonthAgo() {

        Calendar createdAt = Calendar.getInstance();
        createdAt.add(Calendar.MONTH, -1);

        return new Sale(
                new ArrayList<>(Arrays.asList(ClotheMother.promoShirt(), ClotheMother.newCoat())),
                new Cash(),
                createdAt);
    }

    public static Sale fromToday() {

        return new Sale(
                new ArrayList<>(Arrays.asList(ClotheMother.promoShirt(), ClotheMother.newCoat())),
                new Cash(),
                Calendar.getInstance());
    }

}
