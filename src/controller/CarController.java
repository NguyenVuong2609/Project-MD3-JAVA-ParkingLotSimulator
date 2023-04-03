package controller;

import model.Car;
import service.CarService.CarServiceIMPL;

import java.util.List;

public class CarController {
    CarServiceIMPL carService = new CarServiceIMPL();

    public List<Car> getListCar() {
        return carService.findAll();
    }

    public void addCar(Car car) {
        carService.save(car);
    }

    public void removeCarByLicensePlates(String licensePlates) {
        carService.deleteByLicensePlates(licensePlates);
    }
    public Car findByLicensePlates(String licensePlates){
        return carService.findByLicensePlates(licensePlates);
    }
    public long calDifferenceTimeByTicket(String ticket){
        return (carService.getLocalTime().getTime() - carService.getStartTimeByTicket(ticket).getTime());
    }
    public Car findCarByTicket(String ticket){
        return carService.findByTicket(ticket);
    }
}
