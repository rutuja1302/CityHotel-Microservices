//API Gateway by default handles load balancing for us - hence no need to manually configure load balancers


//package com.example.city_microservice.Configurations;
//
//import feign.Feign;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//@LoadBalancerClient(value = "hotel-application") //service name of target server: same as feignclient
//public class HotelLoadBalancerConfig {
//
//
//    @LoadBalanced
//    @Bean
//    public Feign.Builder feignBuilder(){
//        return Feign.builder();
//    }
//}
