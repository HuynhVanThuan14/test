package springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springmvc.service.LoginService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	LoginService loginServiceImpl;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(loginServiceImpl);
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(loginServiceImpl);
		return authenticationProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
//		http.authorizeHttpRequests().requestMatchers("/login").permitAll();
//		http.authorizeHttpRequests().requestMatchers("/", "/home").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/", "/home").access("hasRole('0')");
		
		http.authorizeRequests().and().formLogin()
			.loginProcessingUrl("/j_spring_securty_check")
			.loginPage("/view")
			.defaultSuccessUrl("/login")
			.failureUrl("/login?error=true")
			.usernameParameter("username")
			.passwordParameter("password")
			.and().logout().logoutUrl("/j_spring_securty_logout").logoutSuccessUrl("/login");
	}
}
