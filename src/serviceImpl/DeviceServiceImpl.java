package serviceImpl;

import entity.Device;
import entity.User;
import service.DeviceService;

import java.util.List;

public class DeviceServiceImpl implements DeviceService {
    @Override

    public Boolean addDevice(int num, Device device) {
        /**
         *@Desciprion add devices function
         *@param num the number of device that you want add
         *@param device Device what you want to add
         *@return  true means success,false means unknow error
         */
        return null;
    }

    @Override
    public Boolean removeDevice(int num, Device device) {
        return null;
    }

    @Override
    public List<Device> getDeviceList(User user) {
        return null;
    }
}
