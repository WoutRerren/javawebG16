/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import service.JpaCoursememberDao;

/**
 *
 * @author rerre
 */
@Configuration
@EnableWebMvc
@ComponentScan("controller")

public class WebConfig {
    
    @Bean
    public JpaCoursememberDao coursememberDao(){
        return new JpaCoursememberDao();
    }
}
