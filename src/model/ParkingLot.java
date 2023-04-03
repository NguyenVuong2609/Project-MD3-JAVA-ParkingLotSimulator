package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements Serializable {
    public int id;
    private int size;
    private int filledSize;
    private double fee;
    private List<Car> carList = new ArrayList<>();

    public ParkingLot(int id, int size, double fee) {
        this.id = id;
        this.size = size;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFilledSize() {
        return filledSize;
    }

    public void setFilledSize(int filledSize) {
        this.filledSize = filledSize;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public boolean addCarToParkingLot(Car car) {
        filledSize += (car.getSeats() >= 16) ? 2 : 1;
        if (filledSize < size) {
            carList.add(car);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", size=" + size +
                ", filledSize=" + filledSize +
                ", fee=" + fee +
                ", carList=" + carList +
                '}';
    }
}
