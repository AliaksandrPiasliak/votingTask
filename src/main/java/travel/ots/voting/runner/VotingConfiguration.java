package travel.ots.voting.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring Boot configuration of the voting application.
 */
@SpringBootApplication
@ImportResource({"classpath:spring-config.xml"})
public class VotingConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(VotingConfiguration.class, args);
    }
}
