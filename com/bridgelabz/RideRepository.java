package com.bridgelabz;

import java.util.HashMap;

public class RideRepository {
    HashMap<Integer, Ride[]> rideRepository;
    Integer userId;

    public RideRepository(HashMap<Integer, Ride[]> rideRepository, Integer userId) {
        this.rideRepository = rideRepository;
        this.userId = userId;

    }

    public InvoiceSummery calculateFare() {
        if (this.userId == null || this.rideRepository.get(userId) == null) {
            throw new NullPointerException("Null values cannot be accepted");
        }
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] userDetails = this.rideRepository.get(userId);

        double totalFare = 0;

        for (Ride ride : userDetails) {
            totalFare += cabInvoiceGenerator.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummery(userDetails.length, totalFare);
    }

}
