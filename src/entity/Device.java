package entity;

public class Device {
    String eqid;
    String type;
    Boolean isBreak;
    Boolean isBorrow;

    public Device() {
    }

    public Device(String eqid, String type, Boolean isBreak, Boolean isBorrow) {
        this.eqid = eqid;
        this.type = type;
        this.isBreak = isBreak;
        this.isBorrow = isBorrow;
    }

    public Boolean getAvailiable() {
        return isBorrow;
    }

    public void setAvailiable(Boolean availiable) {
        isBorrow = availiable;
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
