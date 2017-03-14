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

    //选手组别
    int group;

    //选手笔试最终成绩
    int write;

    //选手主题演讲最终成绩
    int speech;

    //选手谈心谈话最终成绩
    int conversation;

    //选手最终总分
    int total;

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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getWrite() {
        return write;
    }

    public void setWrite(int write) {
        this.write = write;
    }

    public int getSpeech() {
        return speech;
    }

    public void setSpeech(int speech) {
        this.speech = speech;
    }

    public int getConversation() {
        return conversation;
    }

    public void setConversation(int conversation) {
        this.conversation = conversation;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
