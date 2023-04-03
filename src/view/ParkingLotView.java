package view;

import config.Config;
import controller.ParkingLotController;
import model.ParkingLot;

import java.util.List;

public class ParkingLotView {
    ParkingLotController parkingLotController = new ParkingLotController();
    List<ParkingLot> parkingLotList = parkingLotController.getParkingLotList();
    public void showParkingLot(int status){
        System.out.println(parkingLotList.get(0));
        System.out.println(Config.QUIT_BACK_MENU);
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Navbar(status);
        }
    }

}
