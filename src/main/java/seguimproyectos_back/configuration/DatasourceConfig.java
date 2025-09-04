package seguimproyectos_back.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Explicación
 *
 * @author Edward Nicolas Montoya Arcila
 * @version 0.0.1
 * @since JDK 1.8
 */
@Configuration
public class DatasourceConfig {

    @Bean
    public JdbcTemplate createJdbcTemplateProd(@Autowired DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}