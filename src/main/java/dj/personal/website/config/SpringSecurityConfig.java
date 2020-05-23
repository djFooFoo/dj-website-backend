package dj.personal.website.config;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import dj.personal.website.Role;
import io.micrometer.core.instrument.util.StringUtils;

@Configuration
class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${cors.maxAge}")
	private Optional<Long> maxAge = Optional.empty();

	@Value("${cors.allowCredentials}")
	private Optional<Boolean> allowCredentials = Optional.empty();

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin")
				.password("{noop}wachtwoordVoorBoeken")
				.roles(Role.ADMIN);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors().and()
				.csrf().disable()
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.logout();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource(
			@Value("#{'${cors.allowed.origins}'.split(',')}") List<String> allowedOrigins,
			@Value("#{'${cors.allowed.methods}'.split(',')}") List<String> allowedMethods,
			@Value("#{'${cors.resolvedMethods}'.split(',')}") List<String> resolvedMethods,
			@Value("#{'${cors.allowedHeaders}'.split(',')}") List<String> allowedHeaders,
			@Value("#{'${cors.exposedHeaders}'.split(',')}") List<String> exposedHeaders) {
		CorsConfiguration configuration = new CorsConfiguration();

		if (notEmptyAndNotContainsBlank(allowedOrigins)) {
			configuration.setAllowedOrigins(allowedOrigins);
		}

		if (notEmptyAndNotContainsBlank(allowedMethods)) {
			configuration.setAllowedMethods(allowedMethods);
		}

		if (notEmptyAndNotContainsBlank(allowedHeaders)) {
			configuration.setAllowedHeaders(allowedHeaders);
		}

		if (notEmptyAndNotContainsBlank(exposedHeaders)) {
			configuration.setExposedHeaders(exposedHeaders);
		}

		allowCredentials.ifPresent(configuration::setAllowCredentials);
		maxAge.ifPresent(configuration::setMaxAge);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	private boolean notEmptyAndNotContainsBlank(Collection<String> collection) {
		return !collection.isEmpty() && collection.stream().noneMatch(StringUtils::isBlank);
	}
}
