package com.sunday.demo;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.sunday.demo.mapper")
public class DemoApplication {

    private static Logger logger = Logger.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        logger.info("SpringBoot Start Success");
	}
}
