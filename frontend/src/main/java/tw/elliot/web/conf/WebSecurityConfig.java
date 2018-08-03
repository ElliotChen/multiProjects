package tw.elliot.web.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${facebook.client.id}")
	private String facebookId;
	@Value("${facebook.client.key}")
	private String facebookKey;

	@Value("${google.client.id}")
	private String googleId;
	@Value("${google.client.key}")
	private String googleKey;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.oauth2Login().clientRegistrationRepository(createClientRegistrationRepository())
				.and()
				.formLogin();
		/*
				.loginPage("/oauth_login")
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll();
				*/
	}

	@Bean
	public ClientRegistrationRepository createClientRegistrationRepository() {
		//List<ClientRegistration> clientRegistrations = Collections.singletonList(clientRegistration());

		return new InMemoryClientRegistrationRepository(clientRegistration());
	}

	private List<ClientRegistration> clientRegistration() {
		List<ClientRegistration> crs = new ArrayList<>();

		CommonOAuth2Provider facebook = CommonOAuth2Provider.FACEBOOK;
		ClientRegistration.Builder fb = facebook.getBuilder("facebook");
		fb.clientId(facebookId).clientSecret(facebookKey);

		CommonOAuth2Provider google = CommonOAuth2Provider.GOOGLE;
		ClientRegistration.Builder gb = google.getBuilder("google").clientId(googleId).clientSecret(googleKey);

		crs.add(fb.build());
		crs.add(gb.build());

		return crs;

		/*
		return new ClientRegistration.Builder("519462111445414")
				.clientSecret("79a432d21b399f7174778a864d0e33ab")
				.clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
				.authorizedGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.redirectUri(redirectUri)
				.scopes("openid", "email", "profile")
				.authorizationUri(authorizationUri)
				.tokenUri(tokenUri)
				.userInfoUri(userInfoUri)
				.clientName("Okta")
				.clientAlias("okta")
				.build();
				*/
	}

}
