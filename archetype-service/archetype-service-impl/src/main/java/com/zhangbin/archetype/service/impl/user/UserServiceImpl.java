package com.zhangbin.archetype.service.impl.user;

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

/**
 * @author zhangbin
 * @Type UserServiceImpl
 * @Desc
 * @date 2017-11-30
 * @Version V1.0
 */
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserManager userManager;

    @Override
    public ResponseDTO<Boolean> insert(UserDTO userDTO) {
        System.out.println("userDTO = " + userDTO);
        userManager.insert(new UserDO());
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
}
