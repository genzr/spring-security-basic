package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /**
         * Default configurations which will secure all the requests
         */
		/*

		((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http.authorizeRequests().anyRequest()).
				authenticated();
		http.formLogin();
		http.httpBasic();

		return (SecurityFilterChain)http.build();

		*/

        /**
         * Custom configurations as per our requirement
         */

        http.authorizeHttpRequests( (auth)->auth
                .antMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                .antMatchers("/notices","/contact").permitAll()
        ).httpBasic(Customizer.withDefaults());

        return http.build();

        /**
         * Configuration to deny all the requests
         */
		/*

		http.authorizeHttpRequests( (auth)->auth
				.anyRequest().denyAll())
				.httpBasic(Customizer.withDefaults());

		return http.build();

		*/

        /**
         * Configuration to permit all the requests
         */
		/*

		http.authorizeHttpRequests( (auth)->auth
						.anyRequest().permitAll())
				.httpBasic(Customizer.withDefaults());

		return http.build();

		*/

    }

}
