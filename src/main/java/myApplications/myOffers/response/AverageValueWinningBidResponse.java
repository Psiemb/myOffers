package myApplications.myOffers.response;

import myApplications.myOffers.dao.Month;

public class AverageValueWinningBidResponse {

    private Month month;
    private double average;

    public AverageValueWinningBidResponse(Month month, double average) {
        this.month = month;
        this.average = average;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "AverageValueWinningBidResponse{" +
                "month=" + month +
                ", average=" + average +
                '}';
    }
}
