package school.be.hackaton_christmas_wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HackatonChristmasWalletApplication {
    public static void main(String[] args) {
        SpringApplication.run(HackatonChristmasWalletApplication.class, args);
    }

}
