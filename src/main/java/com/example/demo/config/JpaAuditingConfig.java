
package com.example.demo.config;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvidor")
public class JpaAuditingConfig {
    
    @Bean
    AuditorAware<String> auditorProvidor(){
        return new AuditorAwareImpl();
    }
    
    class AuditorAwareImpl implements AuditorAware<String>{

        @Override
        public Optional getCurrentAuditor() {
            return Optional.ofNullable("Shovon");
        }
        
    }
}
