package controller;

import model.User;
import service.UserService.UserServiceIMPL;

import java.util.List;

public class UserController {
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();

    public List<User> getListUser() {
        return userServiceIMPL.findAll();
    }

    public void addUser(User user) {
        userServiceIMPL.save(user);
    }

    public void deleteUser(int id) {
        userServiceIMPL.deleteById(id);
    }

    public User findUserById(int id) {
        return userServiceIMPL.findById(id);
    }
    public User checkLogin(String username, String password){
        return userServiceIMPL.checkLogin(username,password);
    }
    public boolean validateUsername(String username){
        return userServiceIMPL.validateUsername(username);
    }
}
