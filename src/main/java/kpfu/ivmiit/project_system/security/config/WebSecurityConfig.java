package kpfu.ivmiit.project_system.security.config;

import kpfu.ivmiit.project_system.security.filter.TokenAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("kpfu.ivmiit.project_system")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private TokenAuthFilter tokenAuthFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(tokenAuthFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authenticationProvider(authenticationProvider)
            .authorizeRequests()
                .antMatchers("/users/**").authenticated()
                .antMatchers("/login").permitAll()
                .antMatchers("/signUp").permitAll();
        http.csrf().disable();
        http.cors().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
