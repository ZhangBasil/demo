package com.zhangbin.archetype.biz.dal.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * @author zhangbin
 * @Type BaseDO
 * @Desc
 * @date 2017-11-29
 * @Version V1.0
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Alias("BaseDO")
public class BaseDO {

    Long id;

    LocalDateTime gmtCreated;

    LocalDateTime gmtModified;

    Integer isDeleted;
}
