package com.gabriel.photoappgateway;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class GlobalFiltersConfiguration {


    @Order(1)
    @Bean
    public GlobalFilter secondFilter() {

        return new GlobalFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("Second pre filter");
                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                    log.info("Second post filter");
                }));
            }
        };
    }


    @Order(2)
    @Bean
    public GlobalFilter thirdFilter() {

        return ((exchange, chain) -> {
            log.info("third pre filter");

            return chain.filter(exchange).then(Mono.fromRunnable(()-> {
                log.info("third post filter");
            }));
        });
    }
}
