package codeJava.countingTheBillSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("codeJava.countingTheBillSystem.models")

public class CountingTheBillSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CountingTheBillSystemApplication.class, args);
    }
}
