package pl.lenistwo.expire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ExpireApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpireApplication.class, args);
    }

}
