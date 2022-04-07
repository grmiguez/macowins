package com.grm.dds.tests;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import com.grm.dds.domain.sale.Sales;
import com.grm.dds.tests.java.mothers.ReportMother;

import org.junit.*;

import junit.framework.TestSuite;

public class SalesReportsTest extends TestSuite {

    @After
    public void clearSales() {
        Sales.getInstance().clearSales();
    }

    @Test
    public void todaySales() {
        ReportMother.reportWithSalesFromTodayAndAMonthAgo();

        assertTrue(Sales.getInstance().salesFrom(Calendar.getInstance()).size() == 2);
    }
}
