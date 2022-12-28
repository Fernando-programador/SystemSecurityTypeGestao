package com.autenticacao.gestao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	

	@Value("${cors.originPatterns:default}")
	private String corsOriginsPatterns= "";
	
	//cors de modo global
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	var origins = corsOriginsPatterns.split(",");
	registry.addMapping("/**")
	//.allowedMethods("GET", "POST") desse modo vc escolhe 
	.allowedMethods("*")
	.allowedOrigins(origins)
	.allowCredentials(true);
	}

}
