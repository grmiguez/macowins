package com.grm.dds.domain.clothe;

import com.grm.dds.domain.clothe.state.ClotheState;

public class ClotheBuilder {

    private float price;
    private ClotheState state;
    private ClotheType type;

    public ClotheBuilder price(float price) {
        this.price = price;

        return this;
    }

    public ClotheBuilder asNew() {
        this.state = ClotheState.NEW;

        return this;
    }

    public ClotheBuilder asPromo() {
        this.state = ClotheState.PROMO;

        return this;
    }

    public ClotheBuilder asSale() {
        this.state = ClotheState.SALE;

        return this;
    }

    public ClotheBuilder coat() {
        this.type = ClotheType.COAT;

        return this;
    }

    public ClotheBuilder shirt() {
        this.type = ClotheType.SHIRT;

        return this;
    }

    public ClotheBuilder trousers() {
        this.type = ClotheType.TROUSERS;

        return this;
    }

    public Clothe build() {
        switch (this.type) {
            case COAT:
                return new Coat(this.price, this.state);
            case SHIRT:
                return new Shirt(this.price, this.state);
            case TROUSERS:
                return new Trousers(this.price, this.state);
            default:
                // En caso de no especificar el tipo de prenda, se devuelve el base (no debería
                // haber problema)
                return new BaseClothe(this.price, this.state);
        }
    }
}
