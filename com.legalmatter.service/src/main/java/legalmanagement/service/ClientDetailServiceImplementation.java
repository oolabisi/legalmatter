package legalmanagement.service;

import legalmanagement.data.Repository.ClientRepository;
import legalmanagement.data.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
@Transactional
public class ClientDetailServiceImplementation implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;

    private static Collection<? extends GrantedAuthority> getAuthorities(Client user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client user = clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email" + email + "not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword().toLowerCase(),
                getAuthorities(user));
    }
}
