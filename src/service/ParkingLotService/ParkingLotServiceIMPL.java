package service.ParkingLotService;

import config.Config;
import model.Car;
import model.ParkingLot;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ParkingLotServiceIMPL implements IParkingLotService{
    List<ParkingLot> parkingLots = new Config<ParkingLot>().readFromFile(Config.PATH_PARKINGLOTINFO);
    @Override
    public List<ParkingLot> findAll() {
        return parkingLots;
    }

    @Override
    public void save(ParkingLot parkingLot) {
        if (findById(parkingLot.getId()) == null) {
            parkingLots.add(parkingLot);
        } else {
            int index = parkingLots.indexOf(findById(parkingLot.getId()));
            parkingLots.set(index,parkingLot);
        }
        new Config<ParkingLot>().writeToFile(Config.PATH_PARKINGLOTINFO, parkingLots);
    }

    @Override
    public ParkingLot findById(int id) {
        for (int i = 0; i < parkingLots.size(); i++) {
            if (parkingLots.get(i).getId() == id) {
                return parkingLots.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        int index = parkingLots.indexOf(findById(id));
        parkingLots.remove(index);
        new Config<ParkingLot>().writeToFile(Config.PATH_PARKINGLOTINFO, parkingLots);
    }

    public boolean fillParkingLot(int seats){
        int filledSize = parkingLots.get(0).getFilledSize();
        filledSize += seats >= 16 ? 2 : 1;
        if (parkingLots.get(0).getSize() >= filledSize){
            parkingLots.get(0).setFilledSize(filledSize);
            return true;
        }
        return false;
    }

    public int calTotalFee(){
        try {
            Date startTime = Calendar.getInstance().getTime();
            Thread.sleep(10000);
            Date endTime = Calendar.getInstance().getTime();

            long difference = endTime.getTime() - startTime.getTime();

            long differenceSeconds = difference / 1000 % 60;
            long differenceMinutes = difference / (60 * 1000) % 60;
            long differenceHours = difference / (60 * 60 * 1000) % 24;
            long differenceDays = difference / (24 * 60 * 60 * 1000);

            System.out.println(differenceDays + " days, ");
            System.out.println(differenceHours + " hours, ");
            System.out.println(differenceMinutes + " minutes, ");
            System.out.println(differenceSeconds + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
