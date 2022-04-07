package com.grm.dds.domain.clothe.state;

public class PriceCalculationStrategy {
    public static ClothePriceCalculation get(ClotheState state) {
        switch (state) {
            case NEW:
                return new New();
            case PROMO:
                return new Promo();
            case SALE:
                return new Sale();
            default:
                // Si no se define un estado de prenda, se la vende como nueva
                return new New();
        }
    }
}
