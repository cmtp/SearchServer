package com.project.SearchProject.config;

import com.project.SearchProject.filter.JWTFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author ctola
 */
@Configuration
@EnableWebSecurity
public class WebOauthConfig extends WebSecurityConfigurerAdapter{
    @Value("${search.server.jwt.token}")
    private String secretKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/*.html", "favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js")
                .permitAll().and()
                .antMatcher("/api/**").addFilterBefore(new JWTFilter(secretKey), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/authentication").permitAll()
                .anyRequest().authenticated();
        http.headers().cacheControl();
    }
}
