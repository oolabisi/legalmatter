package legalmanagement.service;

import legalmanagement.data.Repository.AttorneyRepository;
import legalmanagement.data.Repository.RoleRepository;
import legalmanagement.data.entity.Attorney;
import legalmanagement.data.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

  @Autowired
  private AttorneyRepository attorneyRepository;

  @Autowired
  private RoleRepository roleRepository;

    @Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        Attorney user = attorneyRepository.findByUsername(username);

        if (user == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found User: " + user);

        // [ROLE_USER, ROLE_ADMIN,..]
//        List<String> roleNames = (List<String>) roleRepository.findByRoleId(user.getAttorneyId());
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (roleNames != null) {
//            for (String role : roleNames) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                grantList.add(authority);
//            }
//        }

        Set grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                grantedAuthorities);

//        UserDetails userDetails = (UserDetails) new Attorney(user.getUsername(), user.getPassword(), grantedAuthorities);
//
//        return (User) userDetails;
    }
}
