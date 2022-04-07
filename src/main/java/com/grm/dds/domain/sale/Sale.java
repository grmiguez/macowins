package com.grm.dds.domain.sale;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.grm.dds.domain.clothe.Clothe;

public class Sale {

    private List<Clothe> clothes;
    private Calendar createdAt;
    private PaymentMethod paymentMethod;
    private float finalPrice;

    // Entendemos que cuando se construye la venta, esta está confirmada y ya
    // efectuada.
    public Sale(List<Clothe> clothes, PaymentMethod paymentMethod) {
        this.createdAt = Calendar.getInstance();

        this.buildSale(clothes, paymentMethod);
    }

    // Constructor para registrar ventas en fechas
    public Sale(List<Clothe> clothes, PaymentMethod paymentMethod, Calendar createdAt) {
        this.createdAt = createdAt;

        this.buildSale(clothes, paymentMethod);
    }

    private void buildSale(List<Clothe> clothes, PaymentMethod paymentMethod) {
        this.clothes = clothes;
        this.paymentMethod = paymentMethod;

        this.finalPrice = paymentMethod.calculatePriceToPay(this.getPrices());

        Sales.getInstance().addSale(this);
    }

    // Suma de "precio de venta" de todos los productos
    public List<Float> getPrices() {
        return this.clothes.stream().map(clothe -> clothe.getSalePrice()).collect(Collectors.toList());
    }

    public Calendar date() {
        return this.createdAt;
    }

    public float finalPrice() {
        return this.finalPrice;
    }

}
