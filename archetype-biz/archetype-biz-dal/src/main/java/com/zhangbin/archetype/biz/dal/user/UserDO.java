package com.zhangbin.archetype.biz.dal.user;

import com.zhangbin.archetype.biz.dal.common.BaseDO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.type.Alias;

/**
 * @author zhangbin
 * @Type UserDO
 * @Desc
 * @date 2017-11-29
 * @Version V1.0
 */
@Alias("UserDO")
@Getter
@Setter
@ToString(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDO extends BaseDO {
    String userName;
    String userPwd;
    String userSex;
    Integer userAge;
}
