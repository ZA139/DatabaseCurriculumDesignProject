package entity;

import java.util.Date;

/**
 * @author a1399
 */
public class MaintenanceRecord {
    int maintenanceId;
    String eqId;
    Date startTime;
    Date endTime;

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public MaintenanceRecord() {
    }

    public MaintenanceRecord(int maintenanceId, String eqId, Date startTime, Date endTime) {
        this.maintenanceId = maintenanceId;
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
