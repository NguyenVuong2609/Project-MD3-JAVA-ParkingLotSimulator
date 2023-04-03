package config;


import view.Navbar;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Config<T> {
    public static final String PATH_CAR = "src/database/CarList.txt";
    public static final String PATH_PARKING_LOT_INFO = "src/database/ParkingLotInfo.txt";
    public static final String PATH_USER = "src/database/UserList.txt";
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String QUIT_BACK_MENU = "Enter any key to quit or BACK to return Menu";
    public static final String CONTINUE_BACK_MENU = "Enter any key to continue or BACK to return Menu";
    public static final String NOTIFY_FAIL_LOGIN = "Account does not exist or Wrong password!";
    public static final String NOTIFY_SUCCESS = "Successful!";
    public static final String NOTIFY_FORMAT = "Format is incorrect";
    public static final String NOTIFY_PLUS_NUMBER = "This must be greater than 0";


    public static Scanner scanner() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    public static int validateInt() {
        int data = 0;
        while (true) {
            try {
                data = Integer.parseInt(scanner().nextLine());
                return data;
            } catch (Exception e) {
                System.err.println(NOTIFY_FORMAT);
            }
        }
    }

    public static double validateDouble() {
        double data = 0;
        while (true) {
            try {
                data = Double.parseDouble(scanner().nextLine());
                return data;
            } catch (Exception e) {
                System.err.println(NOTIFY_FORMAT);
            }
        }
    }

    public static boolean validateLicensePlates(String data) {
        final String LICENSE_PLATES_REGEX = "\\d{2}[A-Z]-\\d{4,5}";
        return Pattern.matches(LICENSE_PLATES_REGEX, data);
    }

    public static boolean validatePassword(String data) {
        final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,12}$";
        return Pattern.matches(PASSWORD_REGEX, data);
    }

    public static boolean validateTicket(String ticket) {
        final String TICKET_REGEX = "^\\d{4}-\\d{2}-\\d{2,}";
        return Pattern.matches(TICKET_REGEX, ticket);
    }

    //! Đọc file
    public List<T> readFromFile(String pathFile) {
        List<T> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException f) {
            System.err.println("File not found!");
        } catch (IOException i) {
            System.err.println("IOE exception!");
        } catch (ClassNotFoundException c) {
            System.err.println("Class Not Found!");
        }
        return list;
    }

    //! Ghi file
    public void writeToFile(String pathFile, List<T> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException f) {
            System.err.println("File not found!");
        } catch (IOException i) {
            System.err.println("IOE exception!");
        }
    }
}
