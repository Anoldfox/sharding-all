package org.ywb.subreadwritesplit.controller;

import org.springframework.web.bind.annotation.*;
import org.ywb.easy.vo.ResultVO;
import org.ywb.subreadwritesplit.entity.User;
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
 * @since 2020/5/14 7:34 上午
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public ResultVO<List<User>> list(){
        List<User> users= userService.selectList();
        return ResultVO.buildSuccess(users);
    }

    @PostMapping
    public ResultVO<Void> save(@RequestBody User user){
        userService.save(user);
        return ResultVO.buildSuccess();
    }

}
