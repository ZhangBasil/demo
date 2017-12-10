package com.zhangbin.archetype.biz.dal.user;

import com.zhangbin.base.biz.page.PageQuery;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

/**
 * @author zhangbin
 * @Type UserQuery
 * @Desc
 * @date 2017-12-01
 * @Version V1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserQuery extends PageQuery {
    Long id;
    String userName;
}
