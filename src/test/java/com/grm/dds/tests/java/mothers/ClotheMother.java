package com.grm.dds.tests.java.mothers;

import com.grm.dds.domain.clothe.Clothe;
import com.grm.dds.domain.clothe.ClotheBuilder;

public class ClotheMother {

    public static Clothe newShirt() {
        return (new ClotheBuilder()).shirt().asNew().price(1000).build();
    }

    public static Clothe newCoat() {
        return (new ClotheBuilder()).coat().asNew().price(1000).build();
    }

    public static Clothe newTrousers() {
        return (new ClotheBuilder()).trousers().asNew().price(1000).build();
    }

    public static Clothe promoShirt() {
        return (new ClotheBuilder()).shirt().asPromo().price(1000).build();
    }

    public static Clothe promoCoat() {
        return (new ClotheBuilder()).coat().asPromo().price(1000).build();
    }

    public static Clothe promoTrousers() {
        return (new ClotheBuilder()).trousers().asPromo().price(1000).build();
    }

    public static Clothe saleShirt() {
        return (new ClotheBuilder()).shirt().asSale().price(1000).build();
    }

    public static Clothe saleCoat() {
        return (new ClotheBuilder()).coat().asSale().price(1000).build();
    }

    public static Clothe saleTrousers() {
        return (new ClotheBuilder()).trousers().asSale().price(1000).build();
    }
}
