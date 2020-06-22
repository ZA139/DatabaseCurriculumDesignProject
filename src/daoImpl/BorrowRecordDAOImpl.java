package daoImpl;

import dao.BorrowRecordDAO;
import entity.BorrowRecord;
import entity.Device;
import entity.User;
import service.BorrowRecordService;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class BorrowRecordDAOImpl implements BorrowRecordDAO {
    @Override
    public Boolean addBorrowRecord(String type, User user) {
        try{
            String sql="SELECT deviceid FROM device WHERE isborrow=0 AND type=?";
            Connection connection = DButil.getConnection();
            PreparedStatement preparedStatement = DButil.getPreparedStatement(connection,sql);
            preparedStatement.setString(1,type);
            ResultSet resultSet=preparedStatement.executeQuery();
            String id=null;
            if(resultSet.next()){
                id= resultSet.getString("deviceid");
            }
            DButil.closeAll(resultSet,preparedStatement,connection);
            if(id!=null){
                String sql1="INSERT INTO brecord(username,deviceid,bortime,backtime) VALUES(?,?,?,null)";
                Connection connection1 = DButil.getConnection();
                PreparedStatement preparedStatement1 = DButil.getPreparedStatement(connection1,sql1);
                preparedStatement1.setString(1,user.getUsername());
                preparedStatement1.setString(2,id);
                Date date = new Date();
                long longTime = date.getTime();
                java.sql.Date sDate = new java.sql.Date(longTime);
                preparedStatement1.setDate(3,sDate);
                int n=preparedStatement1.executeUpdate();
                DButil.closeAll(resultSet,preparedStatement1,connection1);
                Device device = null;
                String sq="SELECT * FROM device where deviceid=?";
                Connection conn = DButil.getConnection();
                PreparedStatement stmt = DButil.getPreparedStatement(conn,sq);
                stmt.setString(1,id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                    device=new Device(rs.getString("deviceid"),rs.getString("type"),rs.getBoolean("isbreak"),true);
                }
                DeviceDAOImpl deviceDAO = new DeviceDAOImpl();
                deviceDAO.updateDevice(device);
                DButil.closeAll(rs,stmt,conn);
                if(n>0){
                    return true;
                }
                else{
                    return false;
                }
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
    public Boolean backBorrowRecord(String eqid) {
        try{
            String sql="UPDATE brecord SET backtime=? WHERE deviceid="+eqid;
            Connection connection = DButil.getConnection();
            PreparedStatement preparedStatement = DButil.getPreparedStatement(connection,sql);
            Date date = new Date();
            long longTime = date.getTime();
            java.sql.Date sDate = new java.sql.Date(longTime);
            preparedStatement.setDate(1,sDate);
            int n=preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
            Device device = null;
            String sql1="SELECT * FROM device where deviceid=?";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn,sql1);
            stmt.setString(1,eqid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                device=new Device(rs.getString("deviceid"),rs.getString("type"),rs.getBoolean("isbreak"),false);
            }
            DeviceDAOImpl deviceDAO = new DeviceDAOImpl();
            deviceDAO.updateDevice(device);
            DButil.closeAll(rs,stmt,conn);
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
    public int getSelectedDateBorrowRecord(String date) {
        try{
            String sql="SELECT * FROM brecord WHERE bortime LIKE '"+date+"%'";
            Connection connection = DButil.getConnection();
            PreparedStatement preparedStatement =DButil.getPreparedStatement(connection,sql);
            ResultSet rs=preparedStatement.executeQuery();
            int cnt=0;
            while(rs.next()){
                cnt++;
            }
            preparedStatement.close();
            connection.close();
            rs.close();
            return cnt;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getSelectedDateReturnRecord(String date) {
        try{
            String sql="SELECT * FROM brecord WHERE backtime LIKE '"+date+"%'";
            Connection connection = DButil.getConnection();
            PreparedStatement preparedStatement =DButil.getPreparedStatement(connection,sql);
            ResultSet rs=preparedStatement.executeQuery();
            int cnt=0;
            while(rs.next()){
                cnt++;
            }
            preparedStatement.close();
            connection.close();
            rs.close();
            return cnt;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
