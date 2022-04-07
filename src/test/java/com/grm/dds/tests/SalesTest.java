package com.grm.dds.tests;

import static org.junit.Assert.assertEquals;

import com.grm.dds.domain.sale.Cash;
import com.grm.dds.domain.sale.CreditCard;
import com.grm.dds.domain.sale.Sale;
import com.grm.dds.tests.java.mothers.SaleMother;

import org.junit.*;

import junit.framework.TestSuite;

public class SalesTest extends TestSuite {

    @Test
    public void salePaidWithCash() {
        Sale sale = SaleMother.saleOfOnePromoShirtPaidWithCash();

        validateSalePaidWithCash(sale, sale.finalPrice());
    }

    @Test
    public void salePaidWithCreditCard() {
        int installments = 3;
        Sale sale = SaleMother.saleOfOnePromoShirtPaidWithCreditCard(installments);

        validateSalePaidWithCreditCard(sale, sale.finalPrice(), installments);
    }

    @Test
    public void saleWithMultipleItems() {
        Sale sale = SaleMother.saleOfMultipleItemsPaidWithCash();

        validateSalePaidWithCash(sale, sale.finalPrice());
    }

    private void validateSalePaidWithCash(Sale sale, float actualPrice) {
        Cash expectedPaymentMethod = new Cash();

        assertEquals(actualPrice, expectedPaymentMethod.calculatePriceToPay(sale.getPrices()), 0);
    }

    private void validateSalePaidWithCreditCard(Sale sale, float actualPrice, int installments) {
        CreditCard expectedPaymentMethod = new CreditCard(installments);

        assertEquals(actualPrice, expectedPaymentMethod.calculatePriceToPay(sale.getPrices()), 0);
    }
}
