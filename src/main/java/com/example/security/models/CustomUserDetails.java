package com.example.security.models;

import com.example.UserAuthService.models.Role;
import com.example.UserAuthService.models.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonDeserialize
public class CustomUserDetails implements UserDetails {

    String password;
    String username;
    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialsNonExpired;
    boolean enabled;
    List<GrantedAuthority> authorities;

    public CustomUserDetails() {
        // Default constructor for deserialization
    }

    public CustomUserDetails(User user) {
        this.password = user.getPassword();
        this.username = user.getEmail();
        this.accountNonExpired = true; // Assuming account is not expired
        this.accountNonLocked = true; // Assuming account is not locked
        this.credentialsNonExpired = true; // Assuming credentials are not expired
        this.enabled = true; // Assuming account is enabled
        this.authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            this.authorities.add(new CustomGrantedAuthority(role));

        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
