package com.zhangbin.archetype.biz.core.manager.user.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.zhangbin.archetype.biz.core.manager.user.UserManager;
import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.base.biz.exception.BizException;
import com.zhangbin.base.biz.manager.BaseManagerImpl;

/**
 * @author zhangbin
 * @Type UserManagerImpl
 * @Desc
 * @date 2017-11-29
 * @Version V1.0
 */
@Service
public class UserManagerImpl extends BaseManagerImpl implements UserManager {

    @Override
    public UserDO queryByIdThrowException(Long id) {
        UserDO user = super.queryById(id);
        if (Objects.nonNull(user)) {
            throw new BizException("查询异常");
        }
        return null;
    }
}
