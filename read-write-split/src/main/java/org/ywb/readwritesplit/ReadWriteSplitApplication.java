package org.ywb.readwritesplit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ywb.easy.basic.EnableWebBasic;


@EnableWebBasic
@SpringBootApplication
public class ReadWriteSplitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadWriteSplitApplication.class, args);
    }

}
