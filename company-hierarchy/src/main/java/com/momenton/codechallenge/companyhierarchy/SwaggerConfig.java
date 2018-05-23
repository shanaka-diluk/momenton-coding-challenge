package com.momenton.codechallenge.companyhierarchy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("shanaka", "http://google.com", "my_email@gmail.com");
    
    private static final ApiInfo API_INFO = new ApiInfo("Api Documentation", "Api Documentation of Hierarchy service engine", "1.0", "urn:tos",
            DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",new ArrayList<VendorExtension>());
    
    private static final Set<String> CONSUMES_PRODUCES = new HashSet<>(Arrays.asList("application/json", "application/xml"));
    
    @Bean 
    public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(API_INFO)
		.consumes(CONSUMES_PRODUCES)
		.produces(CONSUMES_PRODUCES)
		.select()
		.apis(RequestHandlerSelectors.any())
		.paths(PathSelectors.any())	
		.build();
    }
}
