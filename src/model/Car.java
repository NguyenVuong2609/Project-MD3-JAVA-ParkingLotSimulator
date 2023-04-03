package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Car implements Serializable {
    private int id;
    private String brand;
    private int seats;
    private String color;
    private String licensePlates;
    private String ticket;
    Date startTime;
    Date endTime;
    long difference;

    public Car(int id, String brand, int seats, String color, String licensePlates, Date startTime, String ticket) {
        this.id = id;
        this.brand = brand;
        this.seats = seats;
        this.color = color;
        this.licensePlates = licensePlates;
        this.ticket = ticket;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = Calendar.getInstance().getTime();
    }

    public long getDifference() {
        return difference;
    }

    public void setDifference(long difference) {
        this.difference = endTime.getTime() - startTime.getTime();
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", seats=" + seats +
                ", color='" + color + '\'' +
                ", licensePlates='" + licensePlates + '\'' +
                ", ticket='" + ticket + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
