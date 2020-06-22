package daoImpl;

import dao.MaintenanceRecordDAO;
import entity.Device;
import entity.MaintenanceRecord;
import entity.User;
import sun.applet.Main;
import util.DButil;

import javax.swing.event.DocumentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class MaintenanceRecordDAOImpl implements MaintenanceRecordDAO {
    @Override
    public Boolean addMaintenanceRecord(Device device) {
        String id = device.getEqid();
        String sql = "INSERT INTO fixrecord(deviceid,starttime,endtime) VALUES (?,?,null)";
        Date date = new Date();
        long longTime = date.getTime();
        java.sql.Date sDate = new java.sql.Date(longTime);
        try{
            Connection connection = DButil.getConnection();
            PreparedStatement preparedStatement = DButil.getPreparedStatement(connection,sql);
            preparedStatement.setString(1,id);
            preparedStatement.setDate(2,sDate);
            int n=preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
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
    public Boolean backMaintenanceRecord(MaintenanceRecord maintenanceRecord) {
        try{
            String sql="UPDATE fixrecord SET endtime=? WHERE fixid=?";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn,sql);
            Date date = new Date();
            long longTime = date.getTime();
            java.sql.Date sDate = new java.sql.Date(longTime);
            stmt.setDate(1,sDate);
            stmt.setInt(2,maintenanceRecord.getMaintenanceId());
            int n=stmt.executeUpdate();
            if(n>0){
                return true;
            }
            else{
                return false;
            }
            //init device
        }catch (Exception e){
            e.printStackTrace();;
            return false;
        }
    }

    @Override
    public MaintenanceRecord queryMaintenanceRecordByDeviceId(String id) {
        try{
            MaintenanceRecord maintenanceRecord = null;
            String sql="SELECT * FROM fixrecord WHERE deviceid=? AND endtime IS NULL";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn,sql);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                java.sql.Date end=rs.getDate(4);
                Date endDate=null;
                if(end!=null)
                    endDate=new Date(rs.getDate(4).getTime());
                maintenanceRecord = new MaintenanceRecord(rs.getInt(1),rs.getString("deviceid"),new Date(rs.getDate(3).getTime()),endDate);
            }
            DButil.closeAll(rs,stmt,conn);
            return maintenanceRecord;
        }catch (Exception e){
           e.printStackTrace();
           return null;
        }
    }
}
