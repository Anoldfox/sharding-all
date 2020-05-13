package org.ywb.subreadwritesplit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ywb.easy.basic.EnableWebBasic;

/**
 * @author tea
 */
@EnableWebBasic
@MapperScan("org.ywb.subreadwritesplit.mapper")
@SpringBootApplication
public class SubReadWriteSplitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubReadWriteSplitApplication.class, args);
    }
}
