package service;

import entity.BorrowRecord;
import entity.User;

/**
 * @author a1399
 */
public interface BorrowRecordService {
    /**
     * add Borrow Record
     *@param type the type of borrowed device
     *@param user Current User
     *@return  true means success,false means unknow error
     */
    public Boolean addBorrowRecord(String type, User user);
    /**
     * Return the Borrowed Device back
     *@param borrowRecord the Record that you want done
     *@return  true means success,false means unknow error
     */
    public Boolean backBorrowRecord(BorrowRecord borrowRecord);
}
