package dao;

import entity.Device;
import entity.MaintenanceRecord;

public interface MaintenanceRecordDAO {
    /**
     * add Maintenance Record
     *@param device The Device to be sent for maintenance
     *@return  true means success,false means unknow error
     */
    public Boolean addMaintenanceRecord(Device device);
    /**
     *Complete the repairment of the device
     *@param maintenanceRecord the Record that you want done
     *@return  true means success,false means unknow error
     */
    public Boolean backMaintenanceRecord(MaintenanceRecord maintenanceRecord);
}
