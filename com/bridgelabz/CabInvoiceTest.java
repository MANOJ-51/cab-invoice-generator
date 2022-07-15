package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
    CabInvoiceGenerator cabInvoiceGenerator;

    @Before
    public void setup() {
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void givenDistanceTimeShouldReturnFare() {
        double fare = cabInvoiceGenerator.calculateFare(2.0, 5);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTimeShouldReturnMinimumFare() {
        double fare = cabInvoiceGenerator.calculateFare(0.1, 1);
        Assert.assertEquals(5, fare, 0.0);
    }
}

