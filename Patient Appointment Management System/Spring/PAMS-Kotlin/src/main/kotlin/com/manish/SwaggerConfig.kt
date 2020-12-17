package com.manish

import com.google.common.base.Predicate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {
    /*
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.codefountain.swagger"))
                //.paths(PathSelectors.any())
                .paths(postPaths())
                .build().apiInfo(apiEndPointInfo());
    }

    private Predicate<String> postPaths() {
		return (regex("/todos.*"));
	}

    public ApiInfo apiEndPointInfo(){
        return new ApiInfoBuilder().title("PAMS Application | Swagger Demo")
                .description("PAMS Application")
                .contact(new Contact("Manish H", "manishhundekar.com", "manishhundekar@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
    */
    @Bean
    fun postsApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .paths(postPaths())
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java) )
                .paths(postPaths())
                .build()
                //apiInfo(apiInfo()).select().paths(PathSelectors.any()).build()

    }

    private fun postPaths(): Predicate<String> {
        return regex("/.*")
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder().title("Patient Appointment Management System")
                .description("PAMS Application")
                .contact(Contact("Manish H", "manishhundekar.com", "manishhundekar@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("0.0.1-SNAPSHOT")
                .build()
    }
}