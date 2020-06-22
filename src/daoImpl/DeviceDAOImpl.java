package daoImpl;

import dao.DeviceDAO;
import entity.Device;
import entity.User;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeviceDAOImpl implements DeviceDAO {
    @Override
    public Boolean addDevice(Device device) {
        String sql="INSERT INTO device VALUES(?,?,?,?)";
        try{
            Connection con = DButil.getConnection();
            PreparedStatement mt = DButil.getPreparedStatement(con,sql);
            mt.setString(1,device.getEqid());
            mt.setString(2,device.getType());
            mt.setBoolean(3,device.getBreak());
            mt.setBoolean(4,device.getAvailiable());
            int n=mt.executeUpdate();
            if(n>0){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean removeDevice(String id) {
            try {
                String sql = "DELETE FROM device WHERE deviceid=?";
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = DButil.getPreparedStatement(conn, sql);
                stmt.setString(1, id);
                int n=stmt.executeUpdate();
                if(n>0){
                    return true;
                }
                else{
                    return false;
                }
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
    }

    @Override
    public List<Device> getDeviceList() {
        List<Device> list=new ArrayList<Device>();
        try {
            String sql="SELECT * FROM device";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn,sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Device(rs.getString("deviceid"),rs.getString("type"),rs.getBoolean("isbreak"),rs.getBoolean("isborrow")));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Device> getBrokenList() {
        List<Device> list=new ArrayList<Device>();
        try {
            String sql="SELECT * FROM device WHERE isbreak=1";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn,sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Device(rs.getString("deviceid"),rs.getString("type"),rs.getBoolean("isbreak"),rs.getBoolean("isborrow")));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Device> getSelectedDeviceList(String type) {
        List<Device> list=new ArrayList<Device>();
        try {
            String sql="SELECT * FROM device WHERE type=?";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn,sql);
            stmt.setString(1,type);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Device(rs.getString("deviceid"),rs.getString("type"),rs.getBoolean("isbreak"),rs.getBoolean("isborrow")));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean updateBreakDevice(Device device) {
        try {
            String sql = "UPDATE device SET isbreak=? WHERE deviceid=?";
            String id=device.getEqid();
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn, sql);
            if(device.getBreak()){
                stmt.setBoolean(1,false);
            }
            else{
                stmt.setBoolean(1,true);
            }
            stmt.setString(2, id);
            int n=stmt.executeUpdate();
            if(n>0){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateDevice(Device device) {
        String sql="UPDATE device SET deviceid=?,type=?,isbreak=?,isborrow=? where deviceid=?";
        try{
            Connection con = DButil.getConnection();
            PreparedStatement mt = DButil.getPreparedStatement(con,sql);
            mt.setString(1,device.getEqid());
            mt.setString(2,device.getType());
            mt.setBoolean(3,device.getBreak());
            mt.setBoolean(4,device.getAvailiable());
            mt.setString(5,device.getEqid());
            int n=mt.executeUpdate();
            if(n>0){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean repairDevice(String id) {
        try {
            MaintenanceRecordDAOImpl maintenanceRecordDAO = new MaintenanceRecordDAOImpl();
            Device device = null;
            String sql="SELECT * FROM device where deviceid=?";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn,sql);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                device=new Device(rs.getString("deviceid"),rs.getString("type"),rs.getBoolean("isbreak"),rs.getBoolean("isborrow"));
            }
            if(device.getBreak()){
                device.setBreak(false);
                device.setAvailiable(true);
                maintenanceRecordDAO.backMaintenanceRecord(maintenanceRecordDAO.queryMaintenanceRecordByDeviceId(id));
            }
            else{
                device.setBreak(true);
                maintenanceRecordDAO.addMaintenanceRecord(device);
                device.setAvailiable(false);
            }
            updateDevice(device);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Device> getUserDeviceList(User user) {
        String username=user.getUsername();
        try{
            Connection connection =DButil.getConnection();
            String sql="SELECT * FROM device WHERE deviceid IN"+
                    "(SELECT deviceid FROM brecord WHERE username=?)";
            PreparedStatement preparedStatement = DButil.getPreparedStatement(connection,sql);
            preparedStatement.setString(1,username);
            ResultSet rs= preparedStatement.executeQuery();
            List<Device> list = new ArrayList<Device>();
            while(rs.next()){
                list.add(new Device(rs.getString(1),rs.getString(2),rs.getBoolean(3),rs.getBoolean(4)));
            }
            DButil.closeAll(rs,preparedStatement,connection);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
