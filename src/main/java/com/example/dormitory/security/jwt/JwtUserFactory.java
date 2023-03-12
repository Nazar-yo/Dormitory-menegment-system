package com.example.dormitory.security.jwt;

import java.util.List;
import java.util.stream.Collectors;
import com.example.dormitory.model.Applicant;
import com.example.dormitory.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(Applicant applicant){
        return new JwtUser(applicant.getId(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getEmail(),
                applicant.getPhoneNumber(),
                applicant.getPassword(),
                mapToAuthority(applicant.getRoles()));
    }

    public static List<GrantedAuthority> mapToAuthority(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
    }
}
