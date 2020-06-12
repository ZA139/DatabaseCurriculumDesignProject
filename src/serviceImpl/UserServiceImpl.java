package serviceImpl;

import entity.Device;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String uId, String upassword, String uType) {
        return null;
    }

    @Override
    public Boolean register(User user) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        DeviceServiceImpl deviceService = new DeviceServiceImpl();
        deviceService.addDevice(1,new Device());
        return null;
    }
}
