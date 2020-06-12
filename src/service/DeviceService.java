package service;

import entity.Device;
import entity.User;

import java.util.List;

public interface DeviceService {
    public Boolean addDevice(int num, Device device);
    public Boolean removeDevice(int num, Device device);
    public List<Device> getDeviceList(User user);
}
