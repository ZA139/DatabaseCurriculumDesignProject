package serviceImpl;

import daoImpl.DeviceDAOImpl;
import entity.Device;
import entity.User;
import service.DeviceService;

import java.util.List;

/**
 * @author a1399
 */
public class DeviceServiceImpl implements DeviceService {
    DeviceDAOImpl deviceDAO=new DeviceDAOImpl();
    @Override
    public Boolean addDevice(Device device) {
        return deviceDAO.addDevice(device);
    }

    @Override
    public Boolean removeDevice(String id) {
        return deviceDAO.removeDevice(id);
    }

    @Override
    public List<Device> getDeviceList() {
        return deviceDAO.getDeviceList();
    }

    @Override
    public List<Device> getBrokenList() {
        return deviceDAO.getBrokenList();
    }

    @Override
    public List<Device> getSelectedDeviceList(String type) {
        return deviceDAO.getSelectedDeviceList(type);
    }

    @Override
    public Boolean updateBreakDevice(Device device) {
        return deviceDAO.updateBreakDevice(device);
    }

    @Override
    public Boolean updateDevice(Device device) {
        return deviceDAO.updateDevice(device);
    }

    @Override
    public Boolean repairDevice(String id) {
        return deviceDAO.repairDevice(id);
    }

    @Override
    public List<Device> getUserDeviceList(User user) {
        return deviceDAO.getUserDeviceList(user);
    }
}
