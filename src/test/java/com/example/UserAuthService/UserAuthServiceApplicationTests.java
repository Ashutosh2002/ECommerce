//package com.example.UserAuthService;
//
////import com.example.security.repositories.JpaRegisteredClientRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.OidcScopes;
//import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
//
//import java.util.UUID;
//
////@SpringBootTest
////public class UserAuthServiceApplicationTests {
////
////    @Autowired
////    private JpaRegisteredClientRepository registeredClientRepository;
////
////	@Autowired
////	BCryptPasswordEncoder bCryptPasswordEncoder;
////
////    @Test
////    public void addSampleClientToDB() {
////        // This is a placeholder for the test case.
////        // You can implement your test logic here.
////        		RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
////				.clientId("oidc-client")
////				.clientSecret(bCryptPasswordEncoder.encode("secret"))
////				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
////				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
////				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
////				.redirectUri("https://oauth.pstmn.io/v1/callback")
////				.postLogoutRedirectUri("http://127.0.0.1:8080/")
//////				.scope(OidcScopes.OPENID)
//////				.scope(OidcScopes.PROFILE)
////                .scope("ADMIN")
////				.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
////				.build();
////////
////		registeredClientRepository.save(oidcClient);
////
////
////
////    }
//
////}
