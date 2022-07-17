package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

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

    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummery() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummery summery = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummery expectedInvoiceSummery = new InvoiceSummery(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummery, summery);
    }

    @Test
    public void givenUserIdShouldReturnRideInvoiceOfUser() {
        HashMap<Integer, Ride[]> rideRepository = new HashMap<>();
        Ride[] rider1 = {new Ride(2.0, 5), new Ride(0.2, 1)};
        Ride[] rider2 = {new Ride(10.0, 2), new Ride(5.2, 1)};
        Ride[] rider3 = {new Ride(7.0, 3), new Ride(2.2, 1)};
        Ride[] rider4 = {new Ride(4.0, 3), new Ride(1.2, 1)};

        rideRepository.put(1, rider1);
        rideRepository.put(2, rider2);
        rideRepository.put(3, rider3);
        rideRepository.put(4, rider4);

        int userId = 1;

        RideRepository rideRepositoryData = new RideRepository(rideRepository, userId);

        InvoiceSummery invoiceSummery = rideRepositoryData.calculateFare();

        InvoiceSummery expectedInvoiceSummery = new InvoiceSummery(2, 30);

        Assert.assertEquals(expectedInvoiceSummery, invoiceSummery);
    }
}

