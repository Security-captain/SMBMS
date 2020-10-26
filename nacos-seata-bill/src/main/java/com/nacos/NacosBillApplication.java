package com.nacos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan(basePackages = "com.nacos.mapper")
@SpringBootApplication
public class NacosBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosBillApplication.class, args);
	}

}
