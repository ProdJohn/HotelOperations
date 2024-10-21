package com.pluralsight;


public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, double price, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getPrice() {
        if (roomType.equalsIgnoreCase("King")) {
            return 139.00;
        } else if (roomType.equalsIgnoreCase("Double")) {
            return 124.00;

        }
    }
        public double roomTotal() {
            double costEachNight = getPrice();
            if (isWeekend) {
                costEachNight *= 1.10; // cost increases if its weekend by 10% of total cost, the 10% is the .10 and the 1 is regular value aka 100% of full price
            }
            return costEachNight * numberOfNights;

        }
    }
}

