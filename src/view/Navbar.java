package view;

import config.Config;
import controller.UserController;
import model.User;


public class Navbar {
    public Navbar(int status) {
        if (status == 0) {
            System.out.println(Config.WHITE_BRIGHT + "❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Car Parking Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀");
            System.out.printf("|" + "  1. %-91s" + "|\n", "Add car to the parking lot");
            System.out.printf("|" + "  2. %-91s" + "|\n", "Take out the car");
            System.out.printf("|" + "  3. %-91s" + "|\n", "Show the list of car in the parking lot");
            System.out.printf("|" + "  4. %-91s" + "|\n", "Find and calculate the fee by car ticket");
            System.out.printf("|" + "  5. %-91s" + "|\n", "Change the fee");
            System.out.printf("|" + "  6. %-91s" + "|\n", "Log out");
            System.out.println("❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Car Parking Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀" + Config.RESET);
            System.out.println("Please enter your choice: ");
            int choice = Config.validateInt();
            switch (choice) {
                case 1:
                    new CarView().addCar(status);
                    break;
                case 2:

                    break;
                case 3:
                    new CarView().showCarList(status);
                    break;
                case 4:
                    new CarView().findAndCalDiffTime(status);
                    break;
                case 5:

                    break;
                case 6:
                    new LoginRegisterView();
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

                    break;
                case 3:
                    new CarView().showCarList(status);
                    break;
                case 4:
                    new CarView().findAndCalDiffTime(status);
                    break;
                case 5:
                    new LoginRegisterView();
            }
        }
    }



    public static void main(String[] args) {
//        new UserController().addUser(new User(0,"admin","admin",true,true));
        new LoginRegisterView();
    }
}
