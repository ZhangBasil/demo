package com.zhangbin.archetype.biz.core.manager.user.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.zhangbin.archetype.biz.core.manager.user.UserManager;
import com.zhangbin.archetype.biz.dal.user.UserDO;
import com.zhangbin.base.biz.exception.BizException;
import com.zhangbin.base.biz.manager.BaseManagerImpl;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void update(UserDO userDO) {
        super.update(userDO);
        if (userDO.getId() == 20) {
            throw new RuntimeException("事物异常............");
        }
    }

    @Override
    @Transactional
    public boolean transactionTest(UserDO userDO) {
        try {
            this.insert(userDO);
            throw new RuntimeException("异常。。。。。。。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
