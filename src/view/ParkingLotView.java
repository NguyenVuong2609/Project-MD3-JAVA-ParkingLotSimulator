package view;

import config.Config;
import controller.ParkingLotController;
import model.ParkingLot;

import java.util.List;

public class ParkingLotView {
    ParkingLotController parkingLotController = new ParkingLotController();
    List<ParkingLot> parkingLotList = parkingLotController.getParkingLotList();

    public void showParkingLot(int status) {
        while (true) {
            System.out.println(parkingLotList.get(0));
            System.out.println(Config.CONTINUE_BACK_MENU);
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Navbar(status);
                break;
            }
        }
    }

    public void changeFee(int status) {
        while (true) {
            System.out.println("Recent fee: " + parkingLotList.get(0).getFee() + "/ 1 hour");
            double fee;
            do {
                System.out.println("Enter the new fee: ");
                fee = Config.validateDouble();
                if (fee <= 0)
                    System.err.println(Config.NOTIFY_PLUS_NUMBER);
            } while (fee <= 0);
            parkingLotController.changeFee(fee);
            System.out.println(Config.NOTIFY_SUCCESS);
            System.out.println(Config.CONTINUE_BACK_MENU);
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Navbar(status);
                break;
            }
        }
    }

    public void changeSize(int status) {
        while (true) {
            System.out.println("Recent size: " + parkingLotList.get(0).getSize());
            int size;
            do {
                System.out.println("Enter the new size: ");
                size = Config.validateInt();
                if (size <= 0)
                    System.err.println(Config.NOTIFY_PLUS_NUMBER);
            } while (size <= 0);
            parkingLotController.changeSize(size);
            System.out.println(Config.NOTIFY_SUCCESS);

            System.out.println(Config.CONTINUE_BACK_MENU);
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Navbar(status);
                break;
            }
        }
    }
}
