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

    public boolean fillParkingLot(int seats) {
        int filledSize = getParkingLotList().get(0).getFilledSize();
        filledSize += seats >= 16 ? 2 : 1;
        if (getParkingLotList().get(0).getSize() >= filledSize) {
            getParkingLotList().get(0).setFilledSize(filledSize);
            return true;
        }
        return false;
    }

    public void changeFee(double fee){
        getParkingLotList().get(0).setFee(fee);
    }
    public void changeSize(int size){
        getParkingLotList().get(0).setSize(size);
    }
}
