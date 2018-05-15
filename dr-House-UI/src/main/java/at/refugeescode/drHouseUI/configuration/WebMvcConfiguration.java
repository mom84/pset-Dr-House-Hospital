package at.refugeescode.drHouseUI.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/invoices").setViewName("invoices");
        registry.addViewController("/admin").setViewName("admin");
        //registry.addViewController("/admin").setViewName("admin");
    }

}
