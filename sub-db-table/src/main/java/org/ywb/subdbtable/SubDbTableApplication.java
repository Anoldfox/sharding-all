package org.ywb.subdbtable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ywb.easy.basic.EnableWebBasic;

/**
 * @author tea
 */
@MapperScan("org.ywb.subdbtable.mapper")
@EnableWebBasic
@SpringBootApplication
public class SubDbTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubDbTableApplication.class, args);
    }

}
