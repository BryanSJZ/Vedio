package com.vedio.dao;

import com.vedio.entity.Competitor;
import com.vedio.util.DBConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ShanJZ
 * @Description
 * @time 2017/3/11 13:06
 */
public class CompetitorDao {


    /**
     * 添加选手信息
     * @param competitor
     */
    public void insert(Competitor competitor){
        DBConn dbConn = new DBConn();
        String sql = "INSERT INTO t_competitor(name,introduction) VALUES(?,?)";
        dbConn.preparedStatement(sql);
        dbConn.setString(1,competitor.getName());
        dbConn.setString(2,competitor.getIntroduction());
        dbConn.executeUpdate();
        dbConn.close();
    }

    /**
     * 通过ID返回选手信息
     * @param id
     * @return
     */
    public Competitor queryById(int id){
        DBConn dbConn = new DBConn();
        String sql = "SELECT * FROM t_competitor WHERE id = " + id;
        dbConn.preparedStatement(sql);
        ResultSet rs = dbConn.executeQuery();
        Competitor competitor = new Competitor();
        try {
            while(rs.next()){
                competitor.setId(rs.getInt("id"));
                competitor.setName(rs.getString("name"));
                competitor.setIntroduction(rs.getString("introduction"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return competitor;
    }

    /**
     * 修改选手信息
     * @param competitor
     * @param id
     */
    public void updateById(Competitor competitor,int id){
        DBConn dbConn = new DBConn();
        String sql = "UPDATE t_competitor SET name = ?,introduction = ? ";
        dbConn.preparedStatement(sql);
        dbConn.setString(1,competitor.getName());
        dbConn.setString(2,competitor.getIntroduction());
        dbConn.executeUpdate();
        dbConn.close();
    }

    /**
     * 删除选手信息
     * @param id
     */
    public void deleteById(int id) {
        DBConn dbConn = new DBConn();
        String sql = "DELETE t_competitor WHERE id = " + id;
        dbConn.preparedStatement(sql);
        dbConn.executeUpdate();
        dbConn.close();
    }
    /**
     * 返回所有选手列表
     * @return
     */
    public List<Competitor> queryAll(){
        DBConn dbConn = new DBConn();
        List<Competitor> list = new ArrayList<>();
        String sql = "SELECT * FROM t_competitor";
        dbConn.preparedStatement(sql);
        ResultSet rs = dbConn.executeQuery();
        try {
            while(rs.next()){
                Competitor competitor = new Competitor();
                competitor.setId(rs.getInt("id"));
                competitor.setName(rs.getString("name"));
                competitor.setIntroduction(rs.getString("introduction"));
                list.add(competitor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
