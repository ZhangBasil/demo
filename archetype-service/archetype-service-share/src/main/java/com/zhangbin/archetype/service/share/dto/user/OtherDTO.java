package com.zhangbin.archetype.service.share.dto.user;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

/**
 * @author zhangbin
 * @Type OtherDTO
 * @Desc
 * @date 2017-12-26
 * @Version V1.0
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OtherDTO implements Serializable {
    @NotNull
    Long id;
    @NotBlank
    @Email(message = "邮件格式不对")
    String email;
}
