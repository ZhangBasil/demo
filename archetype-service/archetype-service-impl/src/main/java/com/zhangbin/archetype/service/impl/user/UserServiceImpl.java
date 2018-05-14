package com.zhangbin.archetype.service.impl.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhangbin.archetype.biz.core.manager.user.UserManager;
import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.archetype.biz.dal.user.UserQuery;
import com.zhangbin.archetype.service.share.UserService;
import com.zhangbin.archetype.service.share.dto.user.UserDTO;
import com.zhangbin.base.biz.page.PageQuery;
import com.zhangbin.base.biz.util.ConverterUtils;
import com.zhangbin.base.share.dto.page.PageDTO;
import com.zhangbin.base.share.dto.response.ResponseDTO;
import com.zhangbin.base.share.util.ResponseUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangbin
 * @Type UserServiceImpl
 * @Desc
 * @date 2017-11-30
 * @Version V1.0
 */
@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserManager userManager;

    @Override
    public ResponseDTO<Boolean> insert(UserDTO userDTO) {
        System.out.println("userDTO = " + userDTO);
        UserDO userDO = ConverterUtils.convertBean(userDTO, UserDO.class);
        userManager.insert(userDO);
        return ResponseUtils.success(Boolean.TRUE);
    }

    @Override
    public ResponseDTO<UserDTO> queryById(Long id) {
        UserDTO userDTO = ConverterUtils.convertBean(userManager.queryById(id), UserDTO.class);
        return ResponseUtils.success(userDTO);
    }

    @Override
    public ResponseDTO<UserDTO> queryByIdThrowException(Long id) {
        UserDTO userDTO = ConverterUtils.convertBean(userManager.queryByIdThrowException(id), UserDTO.class);
        return ResponseUtils.success(userDTO);
    }

    @Override
    public ResponseDTO<PageDTO<UserDTO>> queryByPage() {
        UserQuery userQuery = new UserQuery();
        PageDTO<UserDTO> pageDTO = ConverterUtils.convertPage(userManager.pageQuery(userQuery), UserDTO.class);
        return ResponseUtils.success(pageDTO);
    }

    public ResponseDTO<List<UserDTO>> query(PageQuery pageQuery) {
        List<UserDTO> list = ConverterUtils.convertBeans(userManager.query(pageQuery), UserDTO.class);
        return ResponseUtils.success(list);
    }

    @Override
    public ResponseDTO<Boolean> test(String mobile) {
        System.out.println("mobile = " + mobile);
        return ResponseUtils.success();
    }

    @Override
    @Transactional
    public ResponseDTO<Boolean> updatePwd(Long id, String pwd) {
        System.out.println("pwd = " + pwd);
        UserDO user = userManager.queryById(id);
        String userPwd = user.getUserPwd();
        if (userPwd.equals("zhangbin")) {
            UserDO userDO = new UserDO();
            userDO.setId(id);
            userDO.setUserPwd(pwd);
            System.out.println(" =========== " + pwd + " ============= " + new Date().getTime());
            userManager.update(userDO);
        }
        return ResponseUtils.success(Boolean.TRUE);
    }

}
