package com.changfei.demo.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    //swagger title
    @Value("${swagger.title}")
    private String SWAGGER_TITLE;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，才生成接口文档
                //.apis(RequestHandlerSelectors.basePackage("com.changfei.demo"))
                //.paths(PathSelectors.any())
                //.paths(Predicates.not(PathSelectors.regex("/index*")))//错误路径不监控
                //.paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
                //.paths(PathSelectors.regex("/.*"))
                .build();
    }

    /**
     * 创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(SWAGGER_TITLE)
                //.contact(new Contact("changfei", "", "1244195322@qq.com"))
                //.description("这是SWAGGER_2生成的接口文档")
                //.termsOfServiceUrl("NO terms of service")
                //.license("The Apache License, Version 2.0")
                //.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("v1.0")
                .build();
    }

}
