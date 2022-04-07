package com.grm.dds.domain.sale;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Sales {

    private List<Sale> sales;

    private static Sales instance = null;

    public static Sales getInstance() {
        if (instance == null) {
            instance = new Sales();
        }

        return instance;
    }

    private Sales() {
        this.sales = new ArrayList<Sale>();
    }

    public void addSale(Sale saleToAdd) {
        this.sales.add(saleToAdd);
    }

    public float getTotalSoldByDate(Calendar targetDate) {
        return totalAmountSold(salesFrom(targetDate));
    }

    public List<Sale> salesFrom(Calendar targetDate) {
        return this.sales.stream()
                .filter(sale -> sale.date().get(Calendar.DAY_OF_YEAR) == targetDate.get(Calendar.DAY_OF_YEAR)).toList();
    }

    private float totalAmountSold(List<Sale> sales) {
        List<Float> totals = sales.stream().map(sale -> sale.finalPrice()).collect(Collectors.toList());

        return totals.stream().reduce((float) 0, Float::sum);
    }

    public void clearSales() {
        this.sales.clear();
    }
}
