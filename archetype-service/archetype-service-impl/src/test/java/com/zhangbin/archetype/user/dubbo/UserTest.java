package com.zhangbin.archetype.user.dubbo;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.base.biz.util.ConverterUtils;
import com.zhangbin.base.share.dto.page.PageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangbin.archetype.application.ArchetypeServiceApplication;
import com.zhangbin.archetype.service.share.UserService;
import com.zhangbin.archetype.service.share.dto.user.UserDTO;
import com.zhangbin.base.share.dto.response.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbin
 * @Type UserTest
 * @Desc
 * @date 2017-12-04
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArchetypeServiceApplication.class)
public class UserTest {
    @Resource
    private UserService userService;


    @Test
    public void queryByIdThrowException() {
        ResponseDTO<UserDTO> responseDTO = userService.queryByIdThrowException(1L);
        System.out.println("responseDTO = " + responseDTO);
    }

    @Test
    public void insertUserTest() {
        UserDTO userDTO = new UserDTO();
        userDTO.setMobile("12321312312312321");
        ResponseDTO<Boolean> responseDTO = userService.insert(userDTO);
        System.out.println("responseDTO = " + responseDTO);
    }

    @Test
    public void queryByPage() {
        ResponseDTO<PageDTO<UserDTO>> pageDTOResponseDTO = userService.queryByPage();
        System.out.println("pageDTOResponseDTO = " + pageDTOResponseDTO);
    }
}
