package com.zhangbin.archetype.service.impl.user;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhangbin.archetype.biz.core.manager.user.UserManager;
import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.archetype.service.common.ConverterHandler;
import com.zhangbin.archetype.service.share.UserService;
import com.zhangbin.archetype.service.share.dto.user.UserDTO;
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
        return ResponseUtils.success(ConverterHandler.make(userManager.queryById(id), new UserDTO()));
    }

    @Override
    public ResponseDTO<UserDTO> queryByIdThrowException(Long id) {
        return ResponseUtils.success(ConverterHandler.make(userManager.queryByIdThrowException(id), new UserDTO()));
    }
}
