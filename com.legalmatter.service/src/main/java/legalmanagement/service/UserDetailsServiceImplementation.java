package legalmanagement.service;

import legalmanagement.data.Repository.AttorneyRepository;
import legalmanagement.data.entity.Attorney;
import legalmanagement.data.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
@Primary
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    AttorneyRepository attorneyRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Attorney user = attorneyRepository.findByEmail(email);

        if (user == null) {
            System.out.println("Email not found! " + email);
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }
        System.out.println("Found User: " + user);

        // [ROLE_USER, ROLE_ADMIN,..]
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword()
                .toLowerCase(), grantedAuthorities);
    }
}