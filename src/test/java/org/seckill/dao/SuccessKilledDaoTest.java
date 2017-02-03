package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wenjing on 2017/1/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//spring配置文件路径
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long seckillId   = 1001l;
        long phone = 13728349494l;
        int updateCount = successKilledDao.insertSuccessKilled(seckillId, phone);
        System.out.println("updateCount:"+updateCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long seckillId   = 1001l;
        long phone = 13728349494l;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}