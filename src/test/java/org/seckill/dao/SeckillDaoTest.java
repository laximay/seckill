package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wenjing on 2017/1/8.
 */
//配置spring和junit整合，junit启动加载springIOC容器，spring-test,junit
@RunWith(SpringJUnit4ClassRunner.class)
//spring配置文件路径
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000l, killTime);
        System.out.println(updateCount);
    }

    @Test
    public void queryById() throws Exception {
        long id = 1000;

        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        /**
         * 1000元秒杀iPhone6
         Seckill{seckillId=1000, name='1000元秒杀iPhone6', number='100', startTime=Sun Jan 01 00:00:00 CST 2017, endTime=Sun Jan 01 00:00:00 CST 2017, createTime=Sun Jan 08 17:09:19 CST 2017}
         */

    }

    @Test
    public void queryAll() throws Exception {
           List<Seckill> seckillList=seckillDao.queryAll(0,100);
           for(Seckill seckill : seckillList){
               System.out.println(seckill);
           }
    }

}