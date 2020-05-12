package org.ywb.readwritesplit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author tea
 * email: wenbo_Y@126.com
 * github: https://github.com/xiao-ren-wu
 * @version v1.0.0
 * <p>
 * </p>
 * @since 2020/5/11 8:25 上午
 */
@Data
@TableName("t_user")
public class User {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private String password;

    private Integer cityId;

    private Date createTime;

    private Integer sex;

}