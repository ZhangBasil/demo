package com.zhangbin.archetype.service.share.dto.user;

import com.zhangbin.base.share.constrain.Mobile;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Map;

/**
 * @author zhangbin
 * @Type UserDTO
 * @Desc
 * @date 2017-11-30
 * @Version V1.0
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO implements Serializable {
    @NotBlank
    @Mobile
    String mobile;
    @NotBlank(message = "用户名不能为空")
    String userName;
    @NotBlank(message = "密码不能为空")
    @Size(min = 3, max = 8, message = "密码长度在3-8")
    String userPwd;
    @NotBlank(message = "性别不能为空")
    @Length(min = 1, max = 2, message = "性别有误")
    String userSex;

//    @NotNull
//    @Valid
    OtherDTO otherDTO;

}
