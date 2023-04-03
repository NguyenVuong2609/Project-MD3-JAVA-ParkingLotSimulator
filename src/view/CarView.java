package view;

import config.Config;
import controller.CarController;
import model.Car;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CarView {
    CarController carController = new CarController();
    List<Car> carList = carController.getListCar();

    public void showCarList() {
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println(Config.QUIT_BACK_MENU);
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Navbar();
        }
    }

    public void addCar() {
        while (true) {
            try {
                int id = 0;
                if (carList.size() == 0) {
                    id = 1;
                } else {
                    id = carList.get(carList.size() - 1).getId() + 1;
                }
                System.out.println("Enter the brand: ");
                String brand = Config.scanner().nextLine();
                System.out.println("Enter the seats: ");
                int seats = Config.validateInt();
                System.out.println("Enter the color: ");
                String color = Config.scanner().nextLine();
                String licensePlates;
                do {
                    System.out.println("Enter the license plates");
                    licensePlates = Config.scanner().nextLine();
                    if (!Config.validateLicensePlates(licensePlates))
                        System.err.println("Format is incorrect");
                } while (!Config.validateLicensePlates(licensePlates));
                Date startTime = Calendar.getInstance().getTime();
                String ticket = LocalDate.now().toString() + id;
                Car car = new Car(id, brand, seats, color, licensePlates, startTime, ticket);
                carController.addCar(car);
                System.out.println("Add success!");
                System.out.println(Config.CONTINUE_BACK_MENU);
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Navbar();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeCarByLicensePlates() {
        while (true) {
            try {
                System.out.println("********************** Remove car **********************\n" +
                        "1. Remove by license plates\n" +
                        "2. Remove by ticket\n");
                System.out.println("Enter your choice: ");
                int choice = Config.validateInt();
                switch (choice) {
                    case 1:
                        String licensePlates;
                        do {
                            System.out.println("Enter the license plates: ");
                            licensePlates = Config.scanner().nextLine();
                            if (!Config.validateLicensePlates(licensePlates))
                                System.err.println("Format is incorrect");
                        } while (!Config.validateLicensePlates(licensePlates));
                        if (carController.findByLicensePlates(licensePlates) != null) {
                            carController.removeCarByLicensePlates(licensePlates);
                            System.out.println(Config.CONTINUE_BACK_MENU);
                            String backMenu = Config.scanner().nextLine();
                            if (backMenu.equalsIgnoreCase("back")) {
                                new Navbar();
                                break;
                            }
                        } else {
                            System.out.println("Car does not exist.");
                            System.out.println(Config.CONTINUE_BACK_MENU);
                            String backMenu = Config.scanner().nextLine();
                            if (backMenu.equalsIgnoreCase("back")) {
                                new Navbar();
                                break;
                            }
                        }
                        break;
                    case 2:

                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void findAndCalDiffTime() {
        while (true) {
            try {
                String ticket;
                System.out.println("Enter the ticket: ");
                ticket = Config.scanner().nextLine();
                if (carController.findCarByTicket(ticket) != null) {
                    System.out.println("Duration: " + carController.calDifferenceTimeByTicket(ticket) + " minutes");
                    System.out.println("Fee: " + (carController.calDifferenceTimeByTicket(ticket) * 400));
                    System.out.println(Config.CONTINUE_BACK_MENU);
                    String backMenu = Config.scanner().nextLine();
                    if (backMenu.equalsIgnoreCase("back")) {
                        new Navbar();
                        break;
                    }
                } else {
                    System.out.println("Ticket does not exist.");
                    System.out.println(Config.CONTINUE_BACK_MENU);
                    String backMenu = Config.scanner().nextLine();
                    if (backMenu.equalsIgnoreCase("back")) {
                        new Navbar();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
