package io.xccit.store.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author CH_ywx
 * @date 2023-06-09
 * @description Swagger2配置类
 */
@Configuration
@EnableSwagger2WebMvc
public class Swagger2Config {

    /**
     * 公共API配置
     * @return API
     */
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                //只显示api路径下的页面
                .apis(RequestHandlerSelectors.basePackage("io.xccit.store"))
                .paths(PathSelectors.regex("/api/.*"))
                .build();
    }
    /**
     * admin的API配置
     * @return API
     */
    @Bean
    public Docket adminApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示api路径下的页面
                .apis(RequestHandlerSelectors.basePackage("io.xccit.store"))
                .paths(PathSelectors.regex("/admin/.*"))
                .build();
    }

    /**
     * 公共Api描述
     * @return
     */
    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了优选商城网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("xccit", "https://xccit.io", "darkhorse_1209@outlook.com"))
                .build();
    }
    /**
     * admin的Api描述
     * @return
     */
    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("admin-API文档")
                .description("本文档描述了优选商城网站admin接口定义")
                .version("1.0")
                .contact(new Contact("xccit", "https://xccit.io", "darkhorse_1209@outlook.com"))
                .build();
    }
}
