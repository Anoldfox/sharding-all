package org.ywb.subreadwritesplit.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ywb.subreadwritesplit.entity.User;
import org.ywb.subreadwritesplit.mapper.UserMapper;
import org.ywb.subreadwritesplit.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tea
 * email: wenbo_Y@126.com
 * github: https://github.com/xiao-ren-wu
 * @version v1.0.0
 * <p>
 * </p>
 * @since 2020/5/14 7:36 上午
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
