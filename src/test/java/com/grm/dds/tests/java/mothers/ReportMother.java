package com.grm.dds.tests.java.mothers;

import java.util.Calendar;

import com.grm.dds.domain.sale.Sales;

public class ReportMother {

    /**
     * Devuelve un reporte de ventas con dos ventas de hace un mes y una de hoy
     */
    public static void reportWithSalesFromTodayAndAMonthAgo() {
        Sales.getInstance().addSale(SaleMother.fromAmonthAgo());
        Sales.getInstance().addSale(SaleMother.fromAmonthAgo());
        Sales.getInstance().addSale(SaleMother.fromToday());
    }
}
