package cn.edu.bcu.demo.webstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"cn.edu.bcu.demo"})
@MapperScan(basePackages="cn.edu.bcu.demo.dao")
public class WebApp {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(WebApp.class, args);
    }
}
