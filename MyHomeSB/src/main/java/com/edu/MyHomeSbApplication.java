package com.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value= {"com.edu.board.mapper"})
public class MyHomeSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyHomeSbApplication.class, args);
	}

}
