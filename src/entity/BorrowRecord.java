package entity;

import java.util.Date;

/**
 * @author a1399
 */
public class BorrowRecord {
    int id;
    String username;
    String eqid;
    Date brTime;
    Date backTime;

    public BorrowRecord() {
    }

    public BorrowRecord(int id, String username, String eqid, Date brTime, Date backTime) {
        this.id = id;
        this.username = username;
        this.eqid = eqid;
        this.brTime = brTime;
        this.backTime = backTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public Date getBrTime() {
        return brTime;
    }

    public void setBrTime(Date brTime) {
        this.brTime = brTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }
}
