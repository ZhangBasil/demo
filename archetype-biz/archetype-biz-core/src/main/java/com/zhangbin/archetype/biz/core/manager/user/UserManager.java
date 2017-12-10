package com.zhangbin.archetype.biz.core.manager.user;

import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.base.biz.manager.BaseManager;

/**
 * @author zhangbin
 * @Type UserManager
 * @Desc
 * @date 2017-11-29
 * @Version V1.0
 */
public interface UserManager extends BaseManager {

    UserDO queryByIdThrowException(Long id);

}
