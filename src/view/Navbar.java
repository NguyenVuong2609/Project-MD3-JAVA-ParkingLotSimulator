package view;

import config.Config;


public class Navbar {
    public Navbar() {
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
                new CarView().addCar();
                break;
            case 2:

                break;
            case 3:
                new CarView().showCarList();
                break;
            case 4:
                new CarView().findAndCalDiffTime();
                break;
            case 5:

                break;
            case 6:
                System.exit(0);
        }
    }


    public static void main(String[] args) {
            new Navbar();
    }
}
