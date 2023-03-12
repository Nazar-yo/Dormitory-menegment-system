package com.example.dormitory.security;

import com.example.dormitory.model.Applicant;
import com.example.dormitory.security.jwt.JwtUserFactory;
import com.example.dormitory.service.ApplicantService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {
    private final ApplicantService applicantService;

    public JwtUserDetailService(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Applicant user = applicantService.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User with email: " + email + " dose not exist");
        }

        return JwtUserFactory.create(user);
    }
}
