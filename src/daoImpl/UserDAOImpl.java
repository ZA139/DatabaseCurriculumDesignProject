package daoImpl;

import dao.UserDAO;
import entity.User;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User login(String username, String password, Boolean type) {
        try {
            String sql="SELECT * FROM user WHERE username=?";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn,sql);
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            User user =null;
            if(rs.next()){
                if(rs.getString("password").equals(password)&&rs.getBoolean("type")==type) {
                    user = new User(rs.getString("username"), rs.getString("password"), rs.getBoolean("type"), rs.getString("email"));
                }
            }
            DButil.closeAll(rs,stmt,conn);
            return user;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Boolean register(User user) {
        try {
            String sql="INSERT INTO user VALUES (?,?,?,?)";
            Connection conn = DButil.getConnection();
            PreparedStatement st=DButil.getPreparedStatement(conn,sql);
            st.setString(1,user.getUsername());
            st.setString(2,user.getPassword());
            st.setBoolean(3,user.getType());
            st.setString(4,user.getEmail());
            int n=st.executeUpdate();
            st.close();
            conn.close();
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
    public List<User> getUserList() {
       List<User> list=new ArrayList<User>();
        try {
            String sql="SELECT * FROM user";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn,sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               list.add(new User(rs.getString("username"),rs.getString("password"),rs.getBoolean("type"),rs.getString("email")));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteUser(String username) {
        try {
            String sql = "DELETE FROM user WHERE username=?";
            Connection conn = DButil.getConnection();
            PreparedStatement stmt = DButil.getPreparedStatement(conn, sql);
            stmt.setString(1, username);
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
