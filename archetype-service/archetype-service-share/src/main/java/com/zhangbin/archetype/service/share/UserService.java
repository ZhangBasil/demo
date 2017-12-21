package com.zhangbin.archetype.service.share;

import com.zhangbin.archetype.service.share.dto.user.UserDTO;
import com.zhangbin.base.share.dto.page.PageDTO;
import com.zhangbin.base.share.dto.response.ResponseDTO;

/**
 * @author zhangbin
 * @Type UserService
 * @Desc
 * @date 2017-11-30
 * @Version V1.0
 */
public interface UserService {
    ResponseDTO<Boolean> insert(UserDTO userDTO);

    ResponseDTO<UserDTO> queryById(Long id);

    ResponseDTO<UserDTO> queryByIdThrowException(Long id);

    ResponseDTO<PageDTO<UserDTO>> queryByPage();
}
