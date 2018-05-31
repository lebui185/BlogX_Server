package lebui.blogx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Bean
    public ITemplateResolver templateResolver() {
        ClassLoaderTemplateResolver temlateResolver = new ClassLoaderTemplateResolver();
        
        temlateResolver.setPrefix("templates/");
        temlateResolver.setSuffix(".html");
        temlateResolver.setTemplateMode(TemplateMode.HTML);
        temlateResolver.setCharacterEncoding("UTF-8");
        temlateResolver.setOrder(1);
        
        return temlateResolver;
    }
    
    @Bean
    public ITemplateEngine templateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

}
