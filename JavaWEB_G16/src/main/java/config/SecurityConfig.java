/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author rerre
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
      @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                
                .inMemoryAuthentication()
                .withUser("username").password("123456").roles("USER").and()
                .withUser("wout").password("123456").roles("USER").and()
                .withUser("dylan").password("123456").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().
                defaultSuccessUrl("/welcome").
                loginPage("/login");

        http.authorizeRequests()
                .antMatchers("/welcome*").hasRole("USER").
                and().csrf();
    }
}
