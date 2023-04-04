package view;

import config.Config;
import controller.UserController;
import model.User;

import java.util.List;

public class UserView {
    public UserController userController = new UserController();
    List<User> userList = userController.getListUser();

    public void showUserList(int status){
        System.out.println(userList);
        System.out.println(Config.QUIT_BACK_MENU);
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Navbar(status);
        }
    }
}
