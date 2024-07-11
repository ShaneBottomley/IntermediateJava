// Shane Bottomley Trip Cost Estimator 06/19/2024
//
// The TripCost class constructs a TripCost object and has one method which
// computes the total trip cost based on the following formula;
// gasoline cost = (distance / gas mileage) * gasoline cost
// total trip cost = gasoline cost + (hotel cost + food cost) * number of
// days + attractions

package org.example.project3;

public class TripCost {
    private final double distance;
    private final double gasCost;
    private final double gasMileage;
    private final int numberOfDays;
    private final double hotelCost;
    private final double foodCost;
    private final double attractionsCost;

    //-----Constructor-----
    //create tripcost object which has distance, gas cost, gas mileage,
    // number of days, hotel cost, food cost, and attractions cost
    public TripCost(double distance, double gasCost, double gasMileage,
                    int numberOfDays, double hotelCost, double foodCost,
                    double attractionsCost) {
        this.distance = distance;
        this.gasCost = gasCost;
        this.gasMileage = gasMileage;
        this.numberOfDays = numberOfDays;
        this.hotelCost = hotelCost;
        this.foodCost = foodCost;
        this.attractionsCost = attractionsCost;
    }

    public double computeTotalTripCost() {
        //compute gas cost
        double totalGasCost = (distance / gasMileage) * gasCost;

        double totalTripCost = totalGasCost + (hotelCost + foodCost)
                * numberOfDays + attractionsCost;
        return totalTripCost;

    }

    public double getDistance() {
        return distance;
    }

    public double getGasCost() {
        return gasCost;
    }

    public double getGasMileage() {
        return gasMileage;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getHotelCost() {
        return hotelCost;
    }

    public double getFoodCost() {
        return foodCost;
    }

    public double getAttractionsCost() {
        return attractionsCost;
    }
}
