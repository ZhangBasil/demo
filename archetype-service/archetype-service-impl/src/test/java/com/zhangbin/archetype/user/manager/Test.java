package com.zhangbin.archetype.user.manager;

import com.github.pagehelper.PageInfo;
import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.archetype.service.share.dto.user.UserDTO;
import com.zhangbin.base.biz.util.ConverterUtils;
import com.zhangbin.base.share.dto.page.PageDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbin
 * @Type Test
 * @Desc
 * @date 2017-12-20
 * @Version V1.0
 */
public class Test {



    public static void main(String[] args) {
        UserDO userDO = new UserDO();
        userDO.setUserName("张三");
        userDO.setId(1111L);
        userDO.setUserSex("男");
        List<UserDO> list = new ArrayList<>();
        list.add(userDO);

        PageInfo<UserDO> pageInfo = new PageInfo<>();
        pageInfo.setTotal(100);
        pageInfo.setPageSize(20);
        pageInfo.setPageNum(2);
//        pageInfo.setList(list);

        PageDTO<UserDTO> page = ConverterUtils.convertPage(pageInfo, UserDTO.class);

        System.out.println("PageDTO = " + page);

    }
}
