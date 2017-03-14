package com.vedio.entity;

/**
 * @author ShanJZ
 * @Description 选手实体类
 * @time 2017/3/11 13:00
 */
public class Competitor {
    //选手ID
    int id;

    //选手姓名
    String name;

    //选手的话
    String introduction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
