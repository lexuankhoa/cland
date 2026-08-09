package edu.vinaenter;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		users.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");
		users.setAuthoritiesByUsernameQuery(
				"SELECT u.username, r.name FROM users u INNER JOIN roles r ON u.role_id = r.id WHERE u.username = ?");
		return users;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/cat/edit/**", "/admin/cat/add/**", "/admin/cat/del/**")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_EDITOR")
				.antMatchers("/admin/news/**", "/admin/user/del/**")
				.hasAuthority("ROLE_ADMIN")
				.antMatchers("/admin/user/edit/**", "/admin/**")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "ROLE_EDITOR")
				.anyRequest().permitAll()
			.and()
				.formLogin()
				.usernameParameter("username")
				.passwordParameter("password")
				.loginPage("/auth/login")
				.loginProcessingUrl("/auth/login")
				.failureUrl("/auth/login?msg=Error")
				.defaultSuccessUrl("/admin/index", true)
			.and()
				.logout()
				.logoutUrl("/auth/logout")
				.logoutSuccessUrl("/auth/login")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/error/403")
			.and()
				.csrf().disable();
		return http.build();
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
		JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
		repository.setDataSource(dataSource);
		return repository;
	}
}