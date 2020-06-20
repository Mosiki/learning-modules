package pw.nullpointer.flyway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pw.nullpointer.flyway.mapper")
public class FlywayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlywayApplication.class, args);
    }

}
