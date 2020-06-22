import daoImpl.BorrowRecordDAOImpl;
import entity.Device;
import entity.MaintenanceRecord;
import entity.User;
import serviceImpl.BorrowRecordServiceImpl;
import serviceImpl.DeviceServiceImpl;
import serviceImpl.MaintenanceRecordServiceImpl;

import java.util.Date;
import java.util.List;

public class testclass {
    public static void main(String[] args) {
        BorrowRecordServiceImpl borrowRecordDAO = new BorrowRecordServiceImpl();
        User user = new User("user1","0",false,"1545");
        System.out.println(borrowRecordDAO.getSelectedDateReturnRecord("2020-01"));
    }
}
