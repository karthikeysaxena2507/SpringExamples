package SpringBootAuth.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(UserDetailsService userDetailsService) {
        log.info("Inside Security Configuration");
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(
            AuthenticationManagerBuilder authenticationManagerBuilder
    ) throws Exception {
        log.info("Inside AuthMgrBuilder");
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        log.info("Inside httpSecurity");
        httpSecurity.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/**")
                .permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        log.info("Inside password encoder");
        return new BCryptPasswordEncoder();
    }

}
