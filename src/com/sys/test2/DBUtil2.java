package com.sys.test2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil2 {
    private static String driver = "";
    private static String url = "";
    private static String user = "";
    private static String password = "";

    public static void main(String[] args) {
        System.out.println(getConn());
    }

    static {
        Properties pro = new Properties();
        try {
            pro.load(DBUtil2.class.getResourceAsStream("/db.properties"));
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            System.out.println(driver);
            System.out.println(url);
            System.out.println(user);
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建连接
     *
     * @return
     */
    private static Connection getConn() {
        new DBUtil2();
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
