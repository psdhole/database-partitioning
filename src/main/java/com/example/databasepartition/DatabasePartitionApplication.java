package com.example.databasepartition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type Database partition application.
 */
@SpringBootApplication
@EnableSwagger2
public class DatabasePartitionApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DatabasePartitionApplication.class, args);
    }

}
