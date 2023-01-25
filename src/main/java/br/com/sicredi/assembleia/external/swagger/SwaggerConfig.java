package br.com.sicredi.assembleia.external.swagger;

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
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.sicredi.assembleia"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("API Votação")
                .description("Essa é uma API desenvolvida para teste do Sicredi")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .contact(new Contact("Victor Lopes Teixeira", "https://www.linkedin.com/in/victor-l-teixeira", "victorlopest1@gmail.com"))
                .build();

        return apiInfo;

    }
}
