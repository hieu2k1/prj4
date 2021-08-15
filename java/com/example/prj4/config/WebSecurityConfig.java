package com.example.prj4.config;

import com.example.prj4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService service;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").csrf().disable().authorizeRequests()
                .antMatchers("/", "/index","/register").permitAll()
                .antMatchers("/css/**","/js/**","/images/**","/vendor/**","/img/**","/scss/**").permitAll()
                .antMatchers("/listuser","/createpost","/adduser","/listpost","/editpost/**","/edit/**").hasAuthority("admin")
                .antMatchers("/user").hasAnyAuthority("user","admin")
                .antMatchers("/admin").hasAuthority("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/user")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/404");
    }
}
