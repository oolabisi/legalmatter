package legalmanagement.service;

import legalmanagement.data.Repository.AttorneyRepository;
import legalmanagement.data.Repository.RoleRepository;
import legalmanagement.data.entity.Attorney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

  @Autowired
  private AttorneyRepository attorneyRepository;

  @Autowired
  private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Attorney attorney = this.attorneyRepository.findAttorneyByUsername(username);

        if (attorney == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found User: " + attorney);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = (List<String>) this.roleRepository.findByRoleId(attorney.getAttorneyId());
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(attorney.getUsername(), attorney.getPassword(), grantList);

        return userDetails;
    }
}
