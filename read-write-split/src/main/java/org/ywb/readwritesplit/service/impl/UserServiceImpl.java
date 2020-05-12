package org.ywb.readwritesplit.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ywb.readwritesplit.entity.User;
import org.ywb.readwritesplit.mapper.UserMapper;
import org.ywb.readwritesplit.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tea
 * email: wenbo_Y@126.com
 * github: https://github.com/xiao-ren-wu
 * @version v1.0.0
 * <p>
 * </p>
 * @since 2020/5/11 8:26 上午
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectList() {
        return userMapper.selectList(null);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }
}
