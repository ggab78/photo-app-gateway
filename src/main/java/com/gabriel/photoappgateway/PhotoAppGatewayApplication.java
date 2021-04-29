package com.gabriel.photoappgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PhotoAppGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoAppGatewayApplication.class, args);
    }

}
