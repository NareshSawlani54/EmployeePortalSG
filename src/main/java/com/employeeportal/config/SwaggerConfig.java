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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket employeeServiceApi() {
		Tag employeeControllerTAG = new Tag("Employee RestFul Services","Employee Service For Addition And Listing Of Employee Records");
		Tag departmentControllerTAG = new Tag("Department RestFul Services","Department Service For Listing Of Department Records");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(employeeServiceApiInfo())
				.tags(employeeControllerTAG,departmentControllerTAG)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.employeeportal"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo employeeServiceApiInfo() {
        return new ApiInfoBuilder().title("Employee Portal Service API")
        		.contact(new springfox.documentation.service.Contact("Naresh Sawlani", "www.someurl.com", "nareshsawlani54@gmail.com"))
        		.version("1.0.0").build();
    }

}
