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
				// Define el paquete base de tus controladores
				.apis(RequestHandlerSelectors.basePackage("seguimproyectos_back.controller")).paths(PathSelectors.any())
				.build()
				// Personalización de la información del API
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Sistema de Información de Investigación Universitaria SIIU - UdeA", // Título
				"API REST para la gestión, consulta y seguimiento de proyectos de investigación en la Universidad de Antioquia. "
						+ "Incluye módulos para convocatorias, centros administrativos, tipos de proyecto, procesos de selección y estados de proyectos.", // Descripción
				"1.0.0", // Versión
				"Términos del servicio: Uso exclusivo académico e institucional", // Terms of Service
				new Contact("Equipo de Desarrollo - Universidad de Antioquia", "https://www.udea.edu.co",
						"desarrollo.siiu1@udea.edu.co" // correo de soporte
				), "Licencia MIT", // Licencia
				"https://opensource.org/licenses/MIT", // URL de la licencia
				Collections.emptyList());
	}
}
