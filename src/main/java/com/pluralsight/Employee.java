package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private int hoursWorked;
    private double startTime;

    public Employee(int employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.startTime = -1; // the -1 is to show the employee hasnt punched in yet
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;

    }

    public int getRegularHours() {
        return Math.min(hoursWorked, 40); //regular work week is 40 hours
    }

    public int getOvertimeHours() {
        return Math.max(hoursWorked - 40, 0); //anything above 40 hours is considered overtime pay

    }

    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5; //formula for calculating overtime pay time and a half
        return regularPay + overtimePay;
    }

    public void punchIn(double time) {
        if (startTime == -1) {
            startTime = time;
            System.out.println(name + " punched in at " + time + ".");
        } else {
            System.out.println("Is already Punched in.");
        }
    }

    public void punchIn() {
        if (startTime == -1) {
            LocalDateTime now = LocalDateTime.now();
            double currentTime = convertToDecimalTime(now.getHour(), now.getMinute());
            startTime = currentTime;
            System.out.println(name + " punched in at " + now.format(DateTimeFormatter.ofPattern("HH:mm")) + " Hours worked this shift: " + hoursWorked);
        } else {
            System.out.println("Is already Punched in.");
        }
    }

    public void punchOut(double time) {
        if (startTime != -1) {        //not equal to when start time is -1 its showing employee hasnt started their shift
            double shiftWorkedHours = time - startTime;
            if (shiftWorkedHours > 0) {      //if hours are more than 0 it shows that the employee worked
                hoursWorked += (int) shiftWorkedHours;    // adding int part of shiftworkedhours
                System.out.println(name + "punched out at " + time + " hours worked this shift: " + shiftWorkedHours);
            } else {
                System.out.println("Invalid punch out time.");
            }
            startTime = -1; //next time the time will reset for start time of shift
        } else {
            System.out.println(name + "hasn't punched in to work yet.");
        }
    }

    public void punchOut() {
        if (startTime != -1) {            //not equal to when start time is -1 its showing employee hasnt started their shift
            LocalDateTime now = LocalDateTime.now();
            double currentTime = convertToDecimalTime(now.getHour(), now.getMinute());
            double shiftWorkedHours = currentTime - startTime;
            if (shiftWorkedHours > 0) {          //if hours are more than 0 it shows that the employee worked
                hoursWorked += (int) shiftWorkedHours;        // adding int part of shiftworkedhours
                System.out.println(name + "punched out at " + now.format(DateTimeFormatter.ofPattern("HH:mm")) + " hours worked this shift: " + shiftWorkedHours);
            } else {
                System.out.println("Invalid punch out time.");
            }
            startTime = -1; //next time the time will reset for start time of shift
        } else {
            System.out.println(name + "hasn't punched in to work yet.");
        }
    }

    private double convertToDecimalTime(int hours, int minutes) {
        return hours + (minutes / 60.0);     // this method converts hours and minutes to decimal time like 11:30 = 11.5
    }
}



