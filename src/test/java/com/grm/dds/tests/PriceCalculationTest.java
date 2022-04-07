package com.grm.dds.tests;

import static org.junit.Assert.assertEquals;

import com.grm.dds.domain.clothe.Clothe;
import com.grm.dds.domain.clothe.state.ClotheState;
import com.grm.dds.domain.clothe.state.PriceCalculationStrategy;
import com.grm.dds.tests.java.mothers.ClotheMother;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import junit.framework.TestSuite;

import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class PriceCalculationTest extends TestSuite {

    @DataProvider
    public static Object[] clothe() {
        return new Clothe[] {
                ClotheMother.newCoat(),
                ClotheMother.newShirt(),
                ClotheMother.newTrousers(),
                ClotheMother.promoShirt(),
                ClotheMother.promoCoat(),
                ClotheMother.promoTrousers(),
                ClotheMother.saleShirt(),
                ClotheMother.saleCoat(),
                ClotheMother.saleTrousers()
        };
    }

    @Test
    @UseDataProvider("clothe")
    public void calculatePriceForNewClothe(Clothe clothe) throws Exception {
        float actual = clothe.getSalePrice();
        float originalPrice = clothe.getClothePrice();
        this.validatePriceCalculation(clothe.state(), originalPrice, actual);
    }

    private void assertNew(float originalPrice, float salePrice) {
        assertEquals(PriceCalculationStrategy.get(ClotheState.NEW).calculate(originalPrice), salePrice, 0);
    }

    private void assertPromo(float originalPrice, float salePrice) {
        assertEquals(PriceCalculationStrategy.get(ClotheState.PROMO).calculate(originalPrice), salePrice, 0);
    }

    private void assertSale(float originalPrice, float salePrice) {
        assertEquals(PriceCalculationStrategy.get(ClotheState.SALE).calculate(originalPrice), salePrice, 0);
    }

    private void validatePriceCalculation(ClotheState state, float originalPrice, float salePrice) throws Exception {
        switch (state) {
            case NEW:
                this.assertNew(originalPrice, salePrice);
                break;
            case PROMO:
                this.assertPromo(originalPrice, salePrice);
                break;
            case SALE:
                this.assertSale(originalPrice, salePrice);
                break;
            default:
                throw new Exception("Missing clothe state");
        }
    }

}
