package github.haozi.mybatis.pluslab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("github.haozi.mybatis.pluslab.mapper")
public class PlusLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlusLabApplication.class, args);
    }

}
