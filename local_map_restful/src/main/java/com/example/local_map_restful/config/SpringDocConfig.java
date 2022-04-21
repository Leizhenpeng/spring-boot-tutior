package com.example.local_map_restful.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author river
 */
@Configuration
public class SpringDocConfig {
	@Bean
	public OpenAPI initOpenApi() {
		return new OpenAPI().info(
				new Info()
						.title("LocalMapRestfulApi")
						.description("利用 swagger  和 springboot 写一个 增删改查小例子")
						.version("v1.0")
						.license(new License()
								.name("Apache2.0")
								.url("https://springdoc.org")))
						.externalDocs(new ExternalDocumentation()
								.description("Documentation")
								.url("https://www.jianshu.com/nb/41542276"));
	}
}
