package com.zhangbin.archetype.service.common;

import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.archetype.service.share.dto.user.UserDTO;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangbin
 * @Type ConverterHandler
 * @Desc 转化器处理
 * @date 2017-11-30
 * @Version V1.0
 */
public class ConverterHandler {

    public static <TargetType> TargetType make(Object source, TargetType target) {
        copyProperties(source,target);
        return target;
    }

    private static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }


    public static void main(String[] args) {
       convertBean();
    }

    public static void convertBean() {

        UserDO userDO0 = new UserDO();
        userDO0.setUserName("afdasfadsfadsf");

        UserDO userDO = new UserDO();
        userDO.setUserName("12");
        userDO.setUserPwd("123434");
        userDO.setUserSex("a");
        userDO.setGmtCreated(LocalDateTime.now());
        userDO.setGmtModified(LocalDateTime.now());
        Map<String, Object> others = new HashMap<>();
        others.put("user", userDO0);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);

        System.out.println("userDTO = " + userDTO);

    }

}
