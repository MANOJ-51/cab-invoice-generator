package com.bridgelabz;

public class InvoiceSummery {
    public double averageFare;
    public int totalNumberOfRides;
    public double totalFare;

    public InvoiceSummery(int totalNumberOfRides, double totalFare) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.totalNumberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceSummery summery)) return false;
        return Double.compare(summery.averageFare, averageFare) == 0 && totalNumberOfRides == summery.totalNumberOfRides && Double.compare(summery.totalFare, totalFare) == 0;
    }

}
