package com.vedio.service;

import com.vedio.dao.CompetitorDao;
import com.vedio.entity.Competitor;
import java.util.List;

/**
 * @author ShanJZ
 * @Description
 * @time 2017/3/11 14:21
 */
public class CompetitorService {
    CompetitorDao competitorDao = new CompetitorDao();

    /**
     * 添加一个选手信息
     * @param competitor
     */
    public void insert(Competitor competitor){
        competitorDao.insert(competitor);
    }

    /**
     * 根据ID返回一个选手信息
     * @param id
     * @return
     */
    public Competitor queryById(int id){
        return competitorDao.queryById(id);
    }

    /**
     * 更新选手信息
     * @param competitor
     * @param id
     */
    public void updateById(Competitor competitor,int id){
        competitorDao.updateById(competitor,id);
    }

    /**
     * 删除一个选手的信息
     * @param id
     */
    public void deleteById(int id){
        competitorDao.deleteById(id);
    }
    /**
     * 返回所有选手列表
     * @return
     */
    public List<Competitor> queryAll(){
        return competitorDao.queryAll();
    }

}
