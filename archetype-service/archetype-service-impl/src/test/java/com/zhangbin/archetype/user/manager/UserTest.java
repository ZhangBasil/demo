package com.zhangbin.archetype.user.manager;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.zhangbin.base.biz.page.PageQuery;
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
import org.springframework.transaction.annotation.Transactional;

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
        userDO.setUserName("张三");
        userDO.setUserPwd("12sdfsdf3");
        userDO.setUserSex("女");
        userDO.setUserAge(12);
        userManager.insert(userDO);
    }

    @Test
    public void insertReturnObj() {
        for (int i = 0; i < 10; i++) {
            UserDO userDO = new UserDO();
            userDO.setUserName("李四" + (i + 10));
            userDO.setUserPwd("666666");
            userDO.setUserSex("男");
            userDO.setUserAge(12);
            UserDO user = userManager.insertReturnObj(userDO);
            System.out.println("user = " + user);
        }

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

    @Test
    public void test() {
        UserDO userDO = new UserDO();
        userDO.setUserName("张33");
        userDO.setUserPwd("VVVVV");
        userDO.setUserSex("男");
        boolean bo = userManager.transactionTest(userDO);
        System.out.println("bo = " + bo);
    }

    @Test
    public void updateTransactional() {
        PageQuery query = new UserQuery();
        List<UserDO> list = userManager.query(query);
        System.out.println("list = " + list);

//        for (UserDO user : list) {
//            user.setUserAge(user.getUserAge() + 1);
//            try {
//                userManager.update(user);
//            } catch (Exception e) {
//                System.out.println("e = " + e.getMessage());
//            }
//        }

        list.forEach(l -> {
            l.setUserAge(l.getUserAge() + 1);
            try {
                userManager.update(l);
            } catch (Exception e) {
                System.out.println("e = " + e.getMessage());
            }
        });


    }


}
