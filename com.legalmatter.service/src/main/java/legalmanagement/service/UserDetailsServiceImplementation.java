package legalmanagement.service;

import legalmanagement.data.Repository.AttorneyRepository;
import legalmanagement.data.Repository.RoleRepository;
import legalmanagement.data.entity.Attorney;
import legalmanagement.data.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
@Transactional
public class UserDetailsServiceImplementation implements UserDetailsService {

  @Autowired
  AttorneyRepository attorneyRepository;
  RoleRepository roleRepository;
  BCryptPasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      Attorney user = attorneyRepository.findByEmail(username);

      if (user == null) {
          System.out.println("Email not found! " + username);
          throw new UsernameNotFoundException("User " + username + " was not found in the database");
      }

      System.out.println("Found User: " + user);


      // [ROLE_USER, ROLE_ADMIN,..]

      List<String> roleNames = (List<String>) roleRepository.findByRoleId(user.getAttorneyId());
      List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
      if (roleNames != null) {
          for (String role : roleNames) {
              // ROLE_USER, ROLE_ADMIN,..
              GrantedAuthority authority = new SimpleGrantedAuthority(role);
              grantList.add(authority);
          }
      }

      UserDetails userDetails = (UserDetails) new Attorney(user.getUsername(), user.getPassword(), (Set) grantList);

      return userDetails;
  }

  public void save(Attorney user){
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setEnabled(true);
      Role userRole = roleRepository.findByName("ADMIN");
      user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
      attorneyRepository.save(user);
  }

}



//
//      Set grantedAuthorities = new HashSet<>();
//      for (Role role : user.getRoles()){
//          grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//      }
//
//     return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//              grantedAuthorities);
//  }
//}


//
//      private static Collection<? extends GrantedAuthority> getAuthorities(Attorney user) {
//          String[] attorneyRole = attorney.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
//          Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
//          return (UserDetails) authorities;
//      }

