package lebui.blogx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("lebui.blogx.shared")
@Import({ ThymeleafConfig.class})
public class RootConfig {

}
