package se.trast.trafiklab.sldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHallplatsApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoHallplatsApplication.class);


    public static void main(String[] args) {
        LOGGER.info("Starting the application.");
        SpringApplication.run(DemoHallplatsApplication.class, args);
    }

}
