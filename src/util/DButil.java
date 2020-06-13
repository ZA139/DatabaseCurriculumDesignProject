package util;

import java.sql.*;

/**
 * @author lwq
 */
public class DButil {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载成功！");
            String url = "jdbc:mysql://localhost:3306/news?useUnicode=true&characterEncoding=utf-8";
            String username = "root";
            String password = "721205.asd";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("加载失败！驱动类没有找到！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！请检查数据库名以及用户帐号！");
        }
        return connection;
    }

    // 关闭资源连接connection,statement,resultset
    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    // 创建数据库操作对象preparedStatement
    public static PreparedStatement getPreparedStatement(Connection connection, String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    // 创建数据库操作对象statement
    public static Statement getStatement(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    // 封装DML语句
    public static int excuteDML(String sql, Object...objs) {
        int n = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, sql);
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i+1, objs[i]);
            }
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(null, preparedStatement, connection);
        }
        return n;
    }
}
