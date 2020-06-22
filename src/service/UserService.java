package service;

import entity.User;

import java.util.List;

public interface UserService {
    /**
     *login
     *@param username username
     *@param password password
     * @param type true means admin and false means user
     *@return  null means login failed or return the current user
     */
    public User login(String username, String password, Boolean type);
    /**
     *register
     *@param user the instance of user
     *@return  true means success,false means unknow error
     */
    public Boolean register(User user);
    /**
     *get User list
     *@return  The list of users
     */
    public List<User> getUserList();
    /**
     *delete user
     * @param  username the username of the user what you wanna delete
     *@return  void
     */
    void deleteUser(String username);
}
