package dao;

import entity.BorrowRecord;

import java.util.List;

/**
 * @author a1399
 */
public interface BorrowRecordDAO {
    public List<BorrowRecord> queryAllRecords();

 }
