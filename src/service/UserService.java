package service;

import entity.User;

import java.util.List;

public interface UserService {
    public User login(String uId, String upassword, String uType);
    public Boolean register(User user);
    public List<User> getUserList();
}
