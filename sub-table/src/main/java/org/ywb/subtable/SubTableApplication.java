package org.ywb.subtable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ywb.easy.basic.EnableWebBasic;

@EnableWebBasic
@MapperScan("org.ywb.subtable.mapper")
@SpringBootApplication
public class SubTableApplication {
	public static void main(String[] args) {
		SpringApplication.run(SubTableApplication.class, args);
	}
}
