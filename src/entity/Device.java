package entity;

public class Device {
    String eqid;
    String type;
    Boolean isBreak;
    Boolean isAvailiable;

    public Device() {
    }

    public Device(String eqid, String type, Boolean isBreak, Boolean isAvailiable) {
        this.eqid = eqid;
        this.type = type;
        this.isBreak = isBreak;
        this.isAvailiable = isAvailiable;
    }

    public Boolean getAvailiable() {
        return isAvailiable;
    }

    public void setAvailiable(Boolean availiable) {
        isAvailiable = availiable;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getBreak() {
        return isBreak;
    }

    public void setBreak(Boolean aBreak) {
        isBreak = aBreak;
    }
}
