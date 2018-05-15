package at.refugeescode.accountancy;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Starter {

    @Bean
    ApplicationRunner applicationRunner(AccountancyRepository accountancyRepository){
        return args -> {

            accountancyRepository.deleteAll();
            List<Patient> all = accountancyRepository.findAll();
            System.out.println(all);
        };
    }
}
