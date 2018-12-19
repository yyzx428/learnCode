package scanner.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfig {
    @Bean
    public Integer numOne(){
        return 0;
    }
}
