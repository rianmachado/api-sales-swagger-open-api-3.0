package br.com.rian.sales.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API Sales").description("API de vendas").license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licesen.html")
            .termsOfServiceUrl("api.rian/transacional").version("1.0").contact(new Contact("", "", "bitcoin@rian.com")).build();
    }

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("br.com.rian.sales.api")).build()
            .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
            .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class).apiInfo(apiInfo());
    }

}
