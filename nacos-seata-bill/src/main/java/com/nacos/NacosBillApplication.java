package com.nacos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@MapperScan(basePackages = "com.nacos.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class NacosBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosBillApplication.class, args);
	}

}
