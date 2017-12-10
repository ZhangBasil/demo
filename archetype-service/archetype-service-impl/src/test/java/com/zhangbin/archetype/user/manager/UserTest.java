package com.zhangbin.archetype.user.manager;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.zhangbin.archetype.application.ArchetypeServiceApplication;
import com.zhangbin.archetype.biz.core.manager.user.UserManager;
import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.archetype.biz.dal.user.UserQuery;

/**
 * @author zhangbin
 * @Type UserTest
 * @Desc
 * @date 2017-11-29
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArchetypeServiceApplication.class)
public class UserTest {

    @Autowired
    private UserManager userManager;

    @Test
    public void pageQueryTest() {
        UserQuery userQuery = new UserQuery();
//        userQuery.setUserName("张");
//        userQuery.setPageNum(2);
//        userQuery.setPageSize(3);
        PageInfo<UserDO> pageInfo = userManager.pageQuery(userQuery);
        System.out.println("pageInfo = " + pageInfo);
    }

    @Test
    public void queryTest() {
        UserQuery userQuery = new UserQuery();
        userQuery.setUserName("张");
        List<UserDO> query = userManager.query(userQuery);
        System.out.println("query = " + query);
    }


    @Test
    public void insertTest() {
        UserDO userDO = new UserDO();
        userDO.setUserName("张三22");
        userDO.setUserPwd("123");
        userDO.setUserSex("男");
        userManager.insert(userDO);
    }

    @Test
    public void queryByIdTest() {
        UserDO userDO = userManager.queryById(1L);
        System.out.println("userDO = " + userDO);
    }

    @Test
    public void queryByIdThrowTest() {
        UserDO userDO = userManager.queryByIdThrowException(1L);
        System.out.println("userDO = " + userDO);
    }


}
