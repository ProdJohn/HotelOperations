package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;
    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;

    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }
    public void checkIn() {
        if (!occupied && !dirty) { //this means not occupied and its not dirty !=not
            occupied = true;
            dirty = true;
            System.out.println("The room was checked in successfully.");
        } else {
            System.out.println("The room is already occupied or needs to be cleaned.");
        }
    }
        public void checkOut() {
            if (occupied) {
                occupied = false;
                System.out.println("The room was checked out.");
            }else{
                System.out.println("Room is not occupied.");
            }
        }
        public void cleanRoom () {
        if (dirty) {
            dirty = false;
            System.out.println("The room was sanitized and cleaned. Room is now ready for next guest.");
        } else {
            System.out.println("Room is already sanitized and cleaned.");

        }
    }

}
