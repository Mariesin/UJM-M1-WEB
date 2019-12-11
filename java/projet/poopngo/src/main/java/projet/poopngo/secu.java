package projet.poopngo;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import projet.poopngo.PersonService;


@Configuration
@EnableWebSecurity
public class secu extends WebSecurityConfigurerAdapter {
    
    @Inject
    PersonService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/accueil","/sign_up").permitAll()
                .antMatchers("/order/**","/newState/**","/comment/**").hasRole("USER")
                .antMatchers("/h2_console/**").permitAll()
                ;
        http.authorizeRequests()
        .anyRequest().permitAll();
        http
                .formLogin()
                .and().logout() // NB: CSRF will disallow visiting GET /logout manually
                ;
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
		  .userDetailsService(userDetailsService)
		  .passwordEncoder(userDetailsService.encoder);
	}
}