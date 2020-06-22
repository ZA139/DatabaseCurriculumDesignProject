package serviceImpl;

import daoImpl.BorrowRecordDAOImpl;
import entity.BorrowRecord;
import entity.User;
import service.BorrowRecordService;

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
    public Boolean backBorrowRecord(BorrowRecord borrowRecord) {
        return borrowRecordDAO.backBorrowRecord(borrowRecord);
    }
}
