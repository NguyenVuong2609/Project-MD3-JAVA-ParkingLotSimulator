package service.CarService;

import config.Config;
import model.Car;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CarServiceIMPL implements ICarService{
    List<Car> carList = new Config<Car>().readFromFile(Config.PATH_CAR);

    @Override
    public List<Car> findAll() {
        return carList;
    }

    @Override
    public void save(Car car) {
        if (findByLicensePlates(car.getLicensePlates()) == null) {
            carList.add(car);
        } else {
            int index = carList.indexOf(findByLicensePlates(car.getLicensePlates()));
            carList.set(index,car);
        }
        new Config<Car>().writeToFile(Config.PATH_CAR, carList);
    }

    @Override
    public Car findById(int id) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getId() == id) {
                return carList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        int index = carList.indexOf(findById(id));
        carList.remove(index);
        new Config<Car>().writeToFile(Config.PATH_CAR, carList);
    }

    public Car findByLicensePlates(String plate){
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getLicensePlates().equalsIgnoreCase(plate)) {
                return carList.get(i);
            }
        }
        return null;
    }

    public Car findByTicket(String ticket){
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getTicket().equalsIgnoreCase(ticket)) {
                return carList.get(i);
            }
        }
        return null;
    }

    public void deleteByLicensePlates(String plate){
        int index = carList.indexOf(findByLicensePlates(plate));
        carList.remove(index);
        new Config<Car>().writeToFile(Config.PATH_CAR, carList);
    }

    public Date getStartTimeByLicensePlates(String plate){
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getLicensePlates().equalsIgnoreCase(plate)) {
                return carList.get(i).getStartTime();
            }
        }
        return null;
    }
    public Date getStartTimeByTicket(String ticket){
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getTicket().equalsIgnoreCase(ticket)) {
                return carList.get(i).getStartTime();
            }
        }
        return null;
    }
    public Date getLocalTime(){
        return Calendar.getInstance().getTime();
    }
}
