package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class MySQLServer {

    private static String driver="com.mysql.jdbc.Driver";
    //private static String url="jdbc:mysql://192.168.1.102:3306/mychat";
    private static String url="jdbc:mysql://127.0.0.1:3306/mychat";
    private static String user="qing";
    private static String password="";
    private static Connection connection = null;
    //private static PreparedStatement pstmt = null;
    //private static ResultSet rs =null;
    
        static {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
    public static Connection Connection() throws SQLException {
    	if(connection==null)
    		connection = DriverManager.getConnection(url, user, password);
    	return connection;
    }
   
    public static void closeAll(Connection conn,Statement stmt,ResultSet rs) throws SQLException {
        if(rs!=null) {
            rs.close();
        }
        if(stmt!=null) {
            stmt.close();
        }
        if(conn!=null) {
            conn.close();
        }
    }
    
}