package com.platform.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SoftPlatformApplicationTests {

//    @PersistenceContext
//    EntityManager em;

    @Test
    public void contextLoads() {
//        em.createQuery("select DISTINCT tid from t_loginuser");
    }

}

