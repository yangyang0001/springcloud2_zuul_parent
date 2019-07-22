package com.inspur;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableSwagger2Doc
public class Springcloud2ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springcloud2ZuulGatewayApplication.class, args);
	}

	@RefreshScope
	@ConfigurationProperties(prefix = "zuul")
	public ZuulProperties zuulProperties() {
		return new ZuulProperties();
	}

}
