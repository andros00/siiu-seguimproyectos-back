package seguimproyectos_back.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * Explicación
 *
 * @author Edward Nicolas Montoya Arcila
 * @version 0.0.1
 * @since JDK 1.8
 */
@Configuration
public class DateConfig {
    @Bean
    public SimpleDateFormat formatDate() {
        return new SimpleDateFormat("dd-MMM-yy");
    }

    @Bean
    public DateTimeFormatter formatDateFormatter() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}
