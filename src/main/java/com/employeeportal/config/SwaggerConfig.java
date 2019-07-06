package com.employeeportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.ResolvedType;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SwaggerDefinition(
		info = @Info(
				description = "Employee Service For Addition And Listing",
				version = "1.0.0",
				title = "Employee Management Service",
				contact = @Contact(
						name = "Naresh Sawlani", 
						email = "nareshsawani54@gmail.com", 
						url = "http://www.someurl.com"
						)
				),
		consumes = {"application/json"},
		produces = {"application/json"},
		schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
		)
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		Tag employeeControllerTAG = new Tag("Employee RestFul Services","Employee Addition and Retrival");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.tags(employeeControllerTAG)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.employeeportal"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Portal Service API")
        		.contact(new springfox.documentation.service.Contact("Naresh Sawlani", "www.someurl.com", "nareshsawlani54@gmail.com"))
        		.version("1.0.0").build();
    }

}
