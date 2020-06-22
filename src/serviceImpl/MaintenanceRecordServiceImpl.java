package serviceImpl;

import dao.MaintenanceRecordDAO;
import daoImpl.MaintenanceRecordDAOImpl;
import entity.Device;
import entity.MaintenanceRecord;
import service.MaintenanceRecordService;

public class MaintenanceRecordServiceImpl implements MaintenanceRecordService {
    MaintenanceRecordDAOImpl maintenanceRecordDAO = new MaintenanceRecordDAOImpl();
    @Override
    public Boolean addMaintenanceRecord(Device device) {
        return maintenanceRecordDAO.addMaintenanceRecord(device);
    }

    @Override
    public Boolean backMaintenanceRecord(MaintenanceRecord maintenanceRecord) {
        return maintenanceRecordDAO.backMaintenanceRecord(maintenanceRecord);
    }
}
