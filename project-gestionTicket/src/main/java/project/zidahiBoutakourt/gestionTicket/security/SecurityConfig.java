package project.zidahiBoutakourt.gestionTicket.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import project.zidahiBoutakourt.gestionTicket.security.services.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("123")).roles("USER")
                .and()
                .withUser("user2").password(passwordEncoder().encode("456")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("789")).roles("ADMIN", "USER");*/

        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().defaultSuccessUrl("/clientss/home", true);
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/delete/**", "/save/**, ","/formAppartements/**").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
    }

}