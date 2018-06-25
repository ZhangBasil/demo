package com.zhangbin.archetype.service.share;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zhangbin.archetype.service.share.dto.user.UserDTO;
import com.zhangbin.base.share.constrain.Mobile;
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
    ResponseDTO<Boolean> insert(@Valid UserDTO userDTO);

    ResponseDTO<UserDTO> queryById(@NotNull(message = "id不能为空") @Min(20) Long id);

    ResponseDTO<UserDTO> queryByIdThrowException(Long id);

    ResponseDTO<PageDTO<UserDTO>> queryByPage();

    ResponseDTO<Boolean> test(@Mobile String mobile);

    ResponseDTO<Boolean> updatePwd(@NotNull Long id, @NotBlank String pwd);

    ResponseDTO<String> sayHello(String say);

}
