/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import service.JpaAssessmentDao;
import service.JpaCoursememberDao;

/**
 *
 * @author rerre
 */
@Configuration
@EnableWebMvc
@ComponentScan("controller")
@Import({PersistenceJPAConfig.class,SecurityConfig.class})
public class WebConfig {
    
    @Bean
    public JpaCoursememberDao coursememberDao(){
        return new JpaCoursememberDao();
    }
    @Bean
    public JpaAssessmentDao assessmentDao(){
        return new JpaAssessmentDao();
        }
    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
}
