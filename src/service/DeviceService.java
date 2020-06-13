package service;

import entity.Device;
import entity.User;

import java.util.List;

public interface DeviceService {
    /**
     * add devices function
     *@param device Device what you want to add
     *@return  true means success,false means unknow error
     */
    public Boolean addDevice(Device device);
    /**
     * remove devices function
     *@param device Device what you want to remove
     *@return  true means success,false means unknow error
     */
    public Boolean removeDevice(Device device);
    /**
     *get devices list
     *@return  The list of devices
     */
    public List<Device> getDeviceList();
    /**
     *get Broken Device List
     * Attention:Just Admin can call this function
     *@return  The list of broken devices
     */
    public List<Device> getBrokenList();
    /**
     *get selected type of device list
     * @param type The type of Device
     *@return  The list of selected type device list
     */
    public List<Device> getSelectedDeviceList(String type);
    /**
     *update the isBreak status of the device
     * @param  device which device you want to change status
     *@return  true means success,false means unknow error
     */
    public Boolean updateBreakDevice(Device device);
}
