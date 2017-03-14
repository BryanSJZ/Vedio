package com.vedio.util;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description 连接数据库工具类
 * @Author 单继重
 * @Date 2016/10/26 14:50
 */
public class DBConn {
//    private String DRIVER = "com.mysql.jdbc.Driver";
//    private String USERNAME = "root";
//    private String PASSWORD = "root";
//    private String URL = "jdbc:mysql://localhost:3306/";
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * 第一步：加载数据库驱动
     * 第二步：建立数据库连接
     */
    public DBConn(){
        try {
//            Class.forName(DRIVER);
//            URL = URL + dbName;
//            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Context initCtx = new javax.naming.InitialContext();
            DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/pool");
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    /**
     * 第三步：编写sql语句
     * 第四步：建立sql语句执行器preparedStatement
     * @param sql sql语句
     */
    public void preparedStatement(String sql){
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第五步：将占位符用参数替代
     * @param index 占位符索引（第一个为1）
     * @param value 参数值
     */
    public void setString(int index,String value){
        try {
            ps.setString(index,value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setInt(int index,int value){
        try {
            ps.setInt(index,value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第六步：执行sql语句，返回受影响行数
     * @return 执行sql语句受影响行数
     */
    public int executeUpdate(){
        try {
            //System.out.println(ps);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 第六步：执行sql语句，返回结果集
     * @return ResultSet
     */
    public ResultSet executeQuery(){
        try {
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接以及其他
     */
    public void close(){
        try{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
