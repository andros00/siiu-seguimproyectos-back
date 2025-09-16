package seguimproyectos_back.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("seguimproyectos_back.controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	            "siiu-seguimproyectos-back",
	            "Sistema de información de investigación universitaria",
	            "1.0",
	            "Términos de servicio",
	            new Contact("desarrollo.siiu1", "https://udea.edu.co", "desarrollo.siiu1@udea.edu.co"),
	            "Licencia",
	            "URL de licencia",
	            Collections.emptyList());
	}

}
