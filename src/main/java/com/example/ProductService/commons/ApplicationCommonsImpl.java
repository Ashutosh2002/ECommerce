package com.example.ProductService.commons;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationCommonsImpl implements ApplicationCommons {

    private final RestTemplate restTemplate;

    public ApplicationCommonsImpl(@Qualifier("createLoadBalancedRestTemplateBean") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void validateToken(String tokenValue) {
        // Implement token validation logic here
        // For example, you can check if the token is valid, expired, etc.
        // If the token is invalid, you can throw an exception or return an error response.
        if(tokenValue == null || tokenValue.isEmpty()) {
            throw new RuntimeException("Token value cannot be null or empty");
        }

        String url = "http://ECommerceUserAuthService/auth/validate";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, tokenValue);

        HttpEntity<Void> responseEntity = new HttpEntity<>(headers);

        Boolean isValid = restTemplate.postForObject(url, responseEntity, Boolean.class);

        if(Boolean.FALSE.equals(isValid)) {
            throw new RuntimeException("Invalid token");
        }


    }
}
