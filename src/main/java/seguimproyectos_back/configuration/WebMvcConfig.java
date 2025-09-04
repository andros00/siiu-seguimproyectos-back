package seguimproyectos_back.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Clase que permite configurar el acceso a los servlets. En este caso se usa
 * para leer del paquete principal, configurar los CORS locales y gestionar el
 * archivo de configuración por defecto (application.properties).
 
 * @version 0.0.1
 * @since JDK 1.8
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * Define los servidores desde los cuales es posible generar peticiones Esta
	 * configuración solo estará activa en el ambiente de desarrollo
	 *
	 * @param registry Registro para gestionar los CORS
	 */
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200") // Permitir peticiones desde localhost:4200
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	                .allowedHeaders("*")
	                .allowCredentials(true)
	                .maxAge(3600);
	    }
	/**
	 * Configura los manejadores de recursos estáticos para servir imágenes desde la
	 * carpeta webapp
	 *
	 * @param registry Registro para gestionar los manejadores de recursos
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/static/img/");
    }
}
