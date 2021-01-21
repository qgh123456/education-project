package com.atqgh.micro.common.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lizihao
 * @version 1.0
 * @date 2020/3/10 17:32
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 这个是除了被分组之外的都在这里显示(default)
     * @return
     */
/*    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }*/


    @Bean("元数据")
    public Docket metaApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("元数据")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) // 所有标了API注解的才在文档中展示
                .paths(PathSelectors.regex("/meta.*")) // pms下的所有请求
                .build()
                .apiInfo(metaApiInfo())
                .enable(true);
    }

    private ApiInfo metaApiInfo() {
        return new ApiInfoBuilder()
                .title("数据管理平台-元数据接口文档")
                .description("提供标准化管理的文档")
                .termsOfServiceUrl("http://http://www.bmsoft.com.cn/")
                .version("1.0")
                .build();
    }


    @Bean("标准化管理平台")
    public Docket standardApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("标准化管理平台")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) // 所有标了API注解的才在文档中展示
                .paths(PathSelectors.regex("/standard.*")) // pms下的所有请求
                .build()
                .apiInfo(standardApiInfo())
                .enable(true);
    }

    private ApiInfo standardApiInfo() {
        return new ApiInfoBuilder()
                .title("数据管理平台-标准化管理接口文档")
                .description("提供标准化管理的文档")
                .termsOfServiceUrl("http://http://www.bmsoft.com.cn/")
                .version("1.0")
                .build();
    }

    @Bean("数据质量平台")
    public Docket dataQualityApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("数据质量平台")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) // 所有标了API注解的才在文档中展示
                .paths(PathSelectors.regex("/dataquality.*")) // dataquality下的所有请求
                .build()
                .apiInfo(dataQualityApiInfo())
                .enable(true);
    }

    private ApiInfo dataQualityApiInfo() {
        return new ApiInfoBuilder()
                .title("数据管理平台-数据质量平台接口文档")
                .description("提供数据质量平台的文档")
                .termsOfServiceUrl("http://http://www.bmsoft.com.cn/")
                .version("1.0")
                .build();
    }
}
