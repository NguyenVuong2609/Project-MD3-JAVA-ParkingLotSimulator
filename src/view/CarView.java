package view;

import config.Config;
import controller.CarController;
import controller.ParkingLotController;
import model.Car;
import model.ParkingLot;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CarView {
    CarController carController = new CarController();
    ParkingLotController parkingLotController = new ParkingLotController();
    List<Car> carList = carController.getListCar();
    List<ParkingLot> parkingLotList = parkingLotController.getParkingLotList();

    public void showCarList(int status) {
        if (carList.size() == 0){
            System.out.println(Config.BLUE + "The parking lot is empty" + Config.RESET);
        } else {
            for (Car car : carList) {
                System.out.println(car);
            }
        }
        System.out.println(Config.QUIT_BACK_MENU);
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Navbar(status);
        }
    }

    public void addCar(int status) {
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
                int seats;
                do {
                    System.out.println("Enter the seats: ");
                    seats = Config.validateInt();
                    if (seats <= 0)
                        System.err.println(Config.NOTIFY_FORMAT);
                } while (seats <= 0);
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
                if (parkingLotController.isParkingLotFull(seats)) {
                    Car car = new Car(id, brand, seats, color, licensePlates, startTime, ticket);
                    carController.addCar(car);
                    System.out.println(Config.NOTIFY_SUCCESS);
                } else {
                    System.err.println("Parking lot is full!");
                }
                System.out.println(Config.CONTINUE_BACK_MENU);
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Navbar(status);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeCar(int status) {
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
                                System.err.println(Config.NOTIFY_FORMAT);
                        } while (!Config.validateLicensePlates(licensePlates));
                        if (carController.findByLicensePlates(licensePlates) != null) {
                            System.out.println(calDiffTime(carController.findByLicensePlates(licensePlates).getTicket()));
                            System.out.println("Fee: " + calTotalFeeByTicket(carController.findByLicensePlates(licensePlates).getTicket()));
                            parkingLotController.releaseParkingLot(carController.findByLicensePlates(licensePlates).getSeats());
                            carController.removeCarByLicensePlates(licensePlates);
                            System.out.println(Config.CONTINUE_BACK_MENU);
                            String backMenu = Config.scanner().nextLine();
                            if (backMenu.equalsIgnoreCase("back")) {
                                new Navbar(status);
                                break;
                            }
                        } else {
                            System.out.println("Car does not exist.");
                            System.out.println(Config.CONTINUE_BACK_MENU);
                            String backMenu = Config.scanner().nextLine();
                            if (backMenu.equalsIgnoreCase("back")) {
                                new Navbar(status);
                                break;
                            }
                        }
                        break;
                    case 2:
                        String ticket;
                        do {
                            System.out.println("Enter the ticket: ");
                            ticket = Config.scanner().nextLine();
                            if (!Config.validateTicket(ticket))
                                System.err.println(Config.NOTIFY_FORMAT);
                        } while (!Config.validateTicket(ticket));
                        if (carController.findCarByTicket(ticket) != null) {
                            System.out.println(calDiffTime(ticket));
                            System.out.println("Fee: " + calTotalFeeByTicket(ticket));
                            parkingLotController.releaseParkingLot(carController.findCarByTicket(ticket).getSeats());
                            carController.removeCarByTicket(ticket);
                            System.out.println(Config.CONTINUE_BACK_MENU);
                            String backMenu = Config.scanner().nextLine();
                            if (backMenu.equalsIgnoreCase("back")) {
                                new Navbar(status);
                                break;
                            }
                        } else {
                            System.out.println("Ticket does not exist.");
                            System.out.println(Config.CONTINUE_BACK_MENU);
                            String backMenu = Config.scanner().nextLine();
                            if (backMenu.equalsIgnoreCase("back")) {
                                new Navbar(status);
                                break;
                            }
                        }
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void findAndCalDiffTime(int status) {
        while (true) {
            try {
                String ticket;
                System.out.println("Enter the ticket: ");
                ticket = Config.scanner().nextLine();
                if (carController.findCarByTicket(ticket) != null) {
                    System.out.println(calDiffTime(ticket));
                    System.out.println("Fee: " + calTotalFeeByTicket(ticket));
                    System.out.println(Config.CONTINUE_BACK_MENU);
                    String backMenu = Config.scanner().nextLine();
                    if (backMenu.equalsIgnoreCase("back")) {
                        new Navbar(status);
                        break;
                    }
                } else {
                    System.out.println("Ticket does not exist.");
                    System.out.println(Config.CONTINUE_BACK_MENU);
                    String backMenu = Config.scanner().nextLine();
                    if (backMenu.equalsIgnoreCase("back")) {
                        new Navbar(status);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public double calTotalFeeByTicket(String ticket){
        long getMinutes = (carController.calDifferenceTimeByTicket(ticket) / (60 * 1000) % 60);
        long getHours = (carController.calDifferenceTimeByTicket(ticket) / (60 * 60 * 1000) % 24);
        long getDays = (carController.calDifferenceTimeByTicket(ticket) / (24 * 60 * 60 * 1000));
        double fee = parkingLotList.get(0).getFee();
        return ((getMinutes * fee / 60) + (getHours * fee) + (getDays * fee * 24));
    }
    public String calDiffTime(String ticket){
        long getMinutes = (carController.calDifferenceTimeByTicket(ticket) / (60 * 1000) % 60);
        long getHours = (carController.calDifferenceTimeByTicket(ticket) / (60 * 60 * 1000) % 24);
        long getDays = (carController.calDifferenceTimeByTicket(ticket) / (24 * 60 * 60 * 1000));
        double fee = parkingLotList.get(0).getFee();
        return ("Duration: " + getDays + " days " + getHours + " hours " + getMinutes + " minutes");
    }
}
