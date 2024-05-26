package com.example.api_gateway.Filters;

import org.apache.logging.log4j.LogManager;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.apache.logging.log4j.Logger;

@Configuration
public class CustomLogFilter implements GlobalFilter {
    Logger logger = LogManager.getLogger(CustomLogFilter.class);

    /* Pre filter: Executes cross-cutting concerns such as authentication, authorization, logging, rate limiting etc
     before API Gateway routes request to appropriate service */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        logger.info("Authorization = "+request.getHeaders().getFirst("Authorization"));
        return chain.filter(exchange);
    }
}
