package com.freelancoz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class FreelancozSwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.freelancoz.controllers"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.apiInfo(apiEndPointInfo());
	}

	private ApiInfo apiEndPointInfo() {
		return new ApiInfoBuilder()
				.title("Freelancoz")
				.description("dummy Swagger")
				.contact(new Contact("himalaya", "himalaya.kumar@gmail.com", "himalaya.kumar@gmail.com"))
				.build();
	}
}
