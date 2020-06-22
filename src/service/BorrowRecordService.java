package service;

import entity.BorrowRecord;
import entity.User;

import java.util.List;

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
     *@param eqid the type of borrowed device
     *@return  true means success,false means unknow error
     */
    public Boolean backBorrowRecord(String eqid);
    /**
     * get Selected Date Borrow Record
     *@param date the select date with format"yyyy-mm"
     *@return  the number of selected date of borrow record
     */
    public int getSelectedDateBorrowRecord(String date);
    /**
     * get Selected Date Return Record
     *@param date the select date with format"yyyy-mm"
     *@return  The number of selected date of return record
     */
    public int getSelectedDateReturnRecord(String date);
}
