package tn.esprit.firaseljary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FirasEljaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirasEljaryApplication.class, args);
    }

}
