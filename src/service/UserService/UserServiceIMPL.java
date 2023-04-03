package service.UserService;

import config.Config;
import model.User;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    List<User> userList = new Config<User>().readFromFile(Config.PATH_USER);

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void save(User user) {
        if (findById(user.getUserId()) == null) {
            userList.add(user);
        } else {
            int index = userList.indexOf(findById(user.getUserId()));
            userList.set(index,user);
        }
        new Config<User>().writeToFile(Config.PATH_USER, userList);
    }

    @Override
    public User findById(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserId() == id) {
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        int index = userList.indexOf(findById(id));
        userList.remove(index);
        new Config<User>().writeToFile(Config.PATH_PARKINGLOTINFO, userList);
    }

    public User checkLogin(String userName, String password) {
        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    public boolean validateUsername(String username){
        for (User user : userList){
            if (user.getUserName().equals(username))
                return true;
        }
        return false;
    }
}
