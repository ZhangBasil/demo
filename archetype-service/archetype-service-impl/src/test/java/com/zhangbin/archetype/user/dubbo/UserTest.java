package com.zhangbin.archetype.user.dubbo;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.archetype.service.share.dto.user.OtherDTO;
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
import java.util.concurrent.CountDownLatch;

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

    CountDownLatch countDownLatch = new CountDownLatch(200);

    @Test
    public void queryByIdThrowException() {
        ResponseDTO<UserDTO> responseDTO = userService.queryByIdThrowException(1L);
        System.out.println("responseDTO = " + responseDTO);
    }

    @Test
    public void insertUserTest() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("张三");
        userDTO.setUserSex("男");
        userDTO.setUserPwd("qwqq");
        userDTO.setMobile("17602181809");
        OtherDTO otherDTO = new OtherDTO();
        otherDTO.setId(1L);
        otherDTO.setEmail("531783564@qq.com");
        userDTO.setOtherDTO(otherDTO);
        ResponseDTO<Boolean> responseDTO = userService.insert(userDTO);
        System.out.println("responseDTO = " + responseDTO);
    }

    @Test
    public void multiThreadUserTest() throws InterruptedException {
        Thread[] threads = new Thread[200];
        for (int i = 0; i < 200; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                ResponseDTO<Boolean> update = userService.updatePwd(16L, "zhangbin" + index);
//                System.out.println("update = " + update + "  index :" + index);
            });
//            countDownLatch.countDown();
        }
        for (Thread thread : threads) {
            thread.start();
        }
        Thread.sleep(10000);
    }

    @Test
    public void updateTest() {
        ResponseDTO<Boolean> result = userService.updatePwd(16L, "zhangbin");
        System.out.println("result = " + result);
    }

    @Test
    public void queryByPageTest() {
        ResponseDTO<PageDTO<UserDTO>> pageDTOResponseDTO = userService.queryByPage();
        System.out.println("pageDTOResponseDTO = " + pageDTOResponseDTO);
    }

    @Test
    public void queryByIdTest() {
        // ResponseDTO<Boolean> dto = userService.test("1232");
        // System.out.println("dto = " + dto);

        ResponseDTO<UserDTO> userDTOResponseDTO = userService.queryById(null);
        System.out.println("userDTOResponseDTO = " + userDTOResponseDTO);

    }
}
