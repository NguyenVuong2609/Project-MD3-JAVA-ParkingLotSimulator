package view;

import config.Config;
import controller.ParkingLotController;
import model.ParkingLot;

public class Navbar {
    public Navbar(int status) {
        if (status == 0) {
            System.out.println(Config.WHITE_BRIGHT + "❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Car Parking Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀");
            System.out.printf("|" + "  1. %-91s" + "|\n", "Add car to the parking lot");
            System.out.printf("|" + "  2. %-91s" + "|\n", "Take out the car");
            System.out.printf("|" + "  3. %-91s" + "|\n", "Show the list of car in the parking lot");
            System.out.printf("|" + "  4. %-91s" + "|\n", "Find and calculate the fee by car ticket");
            System.out.printf("|" + "  5. %-91s" + "|\n", "Show Parking Lot info");
            System.out.printf("|" + "  6. %-91s" + "|\n", "Change the fee");
            System.out.printf("|" + "  7. %-91s" + "|\n", "Change the Parking Lot size");
            System.out.printf("|" + "  8. %-91s" + "|\n", "Show the list of user");
            System.out.printf("|" + "  9. %-91s" + "|\n", "Log out");
            System.out.println("❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Car Parking Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀" + Config.RESET);
            System.out.println("Please enter your choice: ");
            int choice = Config.validateInt();
            switch (choice) {
                case 1:
                    new CarView().addCar(status);
                    break;
                case 2:
                    new CarView().removeCar(status);
                    break;
                case 3:
                    new CarView().showCarList(status);
                    break;
                case 4:
                    new CarView().findAndCalDiffTime(status);
                    break;
                case 5:
                    new ParkingLotView().showParkingLot(status);
                    break;
                case 6:
                    new ParkingLotView().changeFee(status);
                    break;
                case 7:
                    new ParkingLotView().changeSize(status);
                    break;
                case 8:
                    new UserView().showUserList(status);
                    break;
                case 9:
                    new LoginRegisterView();
                    break;
            }
        } else if (status == 1){
            System.out.println(Config.WHITE_BRIGHT + "❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Car Parking Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀");
            System.out.printf("|" + "  1. %-91s" + "|\n", "Add car to the parking lot");
            System.out.printf("|" + "  2. %-91s" + "|\n", "Take out the car");
            System.out.printf("|" + "  3. %-91s" + "|\n", "Show the list of car in the parking lot");
            System.out.printf("|" + "  4. %-91s" + "|\n", "Find and calculate the fee by car ticket");
            System.out.printf("|" + "  5. %-91s" + "|\n", "Log out");
            System.out.println("❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Car Parking Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀" + Config.RESET);
            System.out.println("Please enter your choice: ");
            int choice = Config.validateInt();
            switch (choice) {
                case 1:
                    new CarView().addCar(status);
                    break;
                case 2:
                    new CarView().removeCar(status);
                    break;
                case 3:
                    new CarView().showCarList(status);
                    break;
                case 4:
                    new CarView().findAndCalDiffTime(status);
                    break;
                case 5:
                    new LoginRegisterView();
                    break;
            }
        }
    }



    public static void main(String[] args) {
//        new UserController().addUser(new User(0,"admin","admin",true,true));
//        new ParkingLotController().addParkingLot(new ParkingLot(0,200,20000));
        new LoginRegisterView();
    }
}
