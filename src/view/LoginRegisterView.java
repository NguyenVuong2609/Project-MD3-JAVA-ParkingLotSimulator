package view;

import config.Config;
import controller.UserController;
import model.User;


import java.util.List;

public class LoginRegisterView {
    public UserController userController = new UserController();
    List<User> userList = userController.getListUser();

    public LoginRegisterView() {
        System.out.println(Config.WHITE_BRIGHT + "❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀");
        System.out.printf("|" + "  1. %-79s" + "|\n", "Login");
        System.out.printf("|" + "  2. %-79s" + "|\n", "Register");
        System.out.printf("|" + "  3. %-79s" + "|\n", "Exit");
        System.out.println("❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀" + Config.RESET);
        System.out.println("Please enter your choice: ");
        int choice = Config.validateInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.exit(0);
        }
    }

    public void login() {
        do {
            System.out.println("***************** Login *****************");
            System.out.println("Enter your username: ");
            String userName = Config.scanner().nextLine();
            System.out.println("Enter your password: ");
            String password = Config.scanner().nextLine();
            User user = userController.checkLogin(userName, password);
            if (user != null) {
                if (user.isPermission()) {
                    new Navbar(0);
                } else {
                    new Navbar(1);
                }
                break;
            } else {
                System.err.println(Config.NOTIFY_FAIL_LOGIN);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Config.WHITE_BRIGHT + "❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀");
                System.out.printf("|" + "  1. %-79s" + "|\n", "Any number to Re-Login");
                System.out.printf("|" + "  2. %-79s" + "|\n", "Register");
                System.out.printf("|" + "  3. %-79s" + "|\n", "Exit");
                System.out.println("❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀ Menu ❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀" + Config.RESET);
                System.out.println("Please enter your choice: ");
                int choice = Config.validateInt();
                if (choice == 2) {
                    register();
                } else if (choice == 3) {
                    break;
                }
            }
        } while (true);
    }

    public void register() {
        while (true) {
            try {
                int id = 0;
                if (userList.size() == 0) {
                    id = 1;
                } else {
                    id = userList.get(userList.size() - 1).getUserId() + 1;
                }
                System.out.println("***************** Register *****************");
                String userName,password;
                do {
                    System.out.println("Enter username: ");
                    userName = Config.scanner().nextLine();
                    if (userController.validateUsername(userName))
                        System.out.println("Username exist! Please choose another username!");
                } while (userController.validateUsername(userName));
                do {
                    System.out.println("Enter password: ");
                    password = Config.scanner().nextLine();
                    if (!Config.validatePassword(password))
                        System.err.println("Password includes words and numbers, between 6 - 12 characters.");
                } while (!Config.validatePassword(password));
                userController.addUser(new User(id,userName,password,true,false));
                System.out.println("Register success!");
                System.out.println(Config.QUIT_BACK_MENU);
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new LoginRegisterView();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
