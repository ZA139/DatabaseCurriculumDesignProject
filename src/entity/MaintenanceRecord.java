package entity;

import java.util.Date;

/**
 * @author a1399
 */
public class MaintenanceRecord {
    String eqId;
    Date startTime;
    Date endTime;

    public MaintenanceRecord() {
    }

    public MaintenanceRecord(String eqId, Date startTime, Date endTime) {
        this.eqId = eqId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getEqId() {
        return eqId;
    }

    public void setEqId(String eqId) {
        this.eqId = eqId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
