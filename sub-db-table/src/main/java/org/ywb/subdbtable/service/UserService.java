package org.ywb.subdbtable.service;

import org.ywb.subdbtable.entity.User;

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
public interface UserService {
    List<User> selectList();

    void save(User user);

}
