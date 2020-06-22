package serviceImpl;

import daoImpl.BorrowRecordDAOImpl;
import entity.BorrowRecord;
import entity.User;
import service.BorrowRecordService;

import java.util.List;

/**
 * @author a1399
 */
public class BorrowRecordServiceImpl implements BorrowRecordService {
    BorrowRecordDAOImpl borrowRecordDAO=new BorrowRecordDAOImpl();
    @Override
    public Boolean addBorrowRecord(String type, User user) {
        return borrowRecordDAO.addBorrowRecord(type,user);
    }

    @Override
    public Boolean backBorrowRecord(String eqid) {
        return borrowRecordDAO.backBorrowRecord(eqid);
    }

    @Override
    public int getSelectedDateBorrowRecord(String date) {
        return borrowRecordDAO.getSelectedDateBorrowRecord(date);
    }

    @Override
    public int getSelectedDateReturnRecord(String date) {
        return borrowRecordDAO.getSelectedDateReturnRecord(date);
    }
}
