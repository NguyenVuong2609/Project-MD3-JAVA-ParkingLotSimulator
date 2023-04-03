package controller;

import model.ParkingLot;
import service.ParkingLotService.ParkingLotServiceIMPL;


import java.util.List;

public class ParkingLotController {
    ParkingLotServiceIMPL parkingLotServiceIMPL = new ParkingLotServiceIMPL();

    public List<ParkingLot> getParkingLotList() {
        return parkingLotServiceIMPL.findAll();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotServiceIMPL.save(parkingLot);
    }

    public void deleteById(int id) {
        parkingLotServiceIMPL.deleteById(id);
    }

    public boolean isParkingLotFull(int seats) {
        return parkingLotServiceIMPL.isParkingLotFull(seats);
    }
    public void releaseParkingLot(int seats){
        parkingLotServiceIMPL.releaseParkingLot(seats);
    }

    public void changeFee(double fee){
        parkingLotServiceIMPL.changeFee(fee);
    }
    public void changeSize(int size){
        parkingLotServiceIMPL.changeSize(size);
    }
}
