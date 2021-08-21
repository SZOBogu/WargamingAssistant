package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rosterBuilder.pojos.WargameSystemsInitializer;
import rosterBuilder.pojos.WargamingSystem;

import java.util.List;

@Configuration
public class SpringConfig {
    @Bean
    public WargamingSystem wargamingSystem(){
        List<WargamingSystem> wargames = new WargameSystemsInitializer().initialize();
        return wargames.get(0);
    }
}
