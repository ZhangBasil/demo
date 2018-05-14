package com.zhangbin.archetype.biz.dal.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Alias("BaseDO")
public class BaseDO {

    Long id;

    LocalDateTime gmtCreated;

    LocalDateTime gmtModified;

    boolean isDeleted;
}
