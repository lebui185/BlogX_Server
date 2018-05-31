package lebui.blogx;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lebui.blogx.config.RootConfig;
import lebui.blogx.config.WebServiceConfig;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
            RootConfig.class,
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebServiceConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // @Override
    // protected Filter[] getServletFilters() {
    // return new Filter[] { new OpenEntityManagerInViewFilter() };
    // }

}
