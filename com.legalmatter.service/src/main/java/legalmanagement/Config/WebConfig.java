package legalmanagement.Config;


import legalmanagement.service.ClientDetailServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    ClientDetailServiceImplementation clientDetailServiceImplementation;

    @Autowired
    DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Setting Service to find User in the database.
        // And Setting PasswordEncoder
        auth .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .userDetailsService(clientDetailServiceImplementation)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository () {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

    @Configuration
    @Order(1)
    public static class AppConfigurationAdapter extends WebSecurityConfigurerAdapter{

        public AppConfigurationAdapter(){
        super();
    }
    @Override
        protected void configure(HttpSecurity http) throws Exception {

            http
                    .headers()
                    .frameOptions()
                    .sameOrigin()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/resources/**", "/webjars/**", "/js/**", "/css/**", "/img/**", "/assets/**")
                    .permitAll()

                    .and()
                    .antMatcher("/")

                   // .and()
                    .antMatcher("/attorney*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("USER")

                    .and()
                    .formLogin()
                    .loginPage("/login_attorney")
                    .loginProcessingUrl("/attorney_login")
                    .failureUrl("/loginAttorney?error=loginError")
                    .defaultSuccessUrl("/attorneyPage", true)

                    .and()
                    .logout()
                    .logoutUrl("/attorney_logout")
                    .logoutSuccessUrl("/login_attorney")
                    .deleteCookies("my-remember-me-cookies")

                    .and()
                    .rememberMe()
                    .key("my-secure-key")
                    .rememberMeCookieName("my-remember-me-cookie")
                    //.tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(24 * 60 * 60)




                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")

                    .and()
                    .csrf()
                    .disable();
        }
    }

    @Configuration
    @Order(2)
    public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter{

        public App2ConfigurationAdapter(){
            super();
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http
                    .headers()
                    .frameOptions()
                    .sameOrigin()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/resources/**", "/webjars/**", "/js/**", "/css/**", "/img/**", "/assets/**")
                    .permitAll()

                    .and()
                    .antMatcher("/")

                    .antMatcher("/client*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("USER")

                    .and()
                    .formLogin()
                    .loginPage("/loginClient")
                    .loginProcessingUrl("/client_login")
                    .failureUrl("/loginClient?error=loginError")
                    .defaultSuccessUrl("/clientPage")

                    .and()
                    .logout()
                    .logoutUrl("/client_logout")
                    .logoutSuccessUrl("/protectedLinks")
                    .deleteCookies("my-remember-me-cookie")

                    .and()
                    .rememberMe()
                    .key("my-secure-key")
                    .rememberMeCookieName("my-remember-me-cookie")
                    //.tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(24 * 60 * 60)


                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")

                    .and()
                    .csrf()
                    .disable();
        }
    }
}
