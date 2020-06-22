package serviceImpl;

import daoImpl.UserDAOImpl;
import entity.Device;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDAOImpl userDAO = new UserDAOImpl();
    @Override
    public User login(String username, String password, Boolean type) {
        return userDAO.login(username,password,type);
    }

    @Override
    public Boolean register(User user) {
        return userDAO.register(user);
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    @Override
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }
}
