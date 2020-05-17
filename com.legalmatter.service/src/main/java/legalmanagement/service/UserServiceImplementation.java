package legalmanagement.service;

import legalmanagement.data.Repository.AttorneyRepository;
import legalmanagement.data.Repository.RoleRepository;
import legalmanagement.data.entity.Attorney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private AttorneyRepository attorneyRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Attorney user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        attorneyRepository.save(user);
    }

    @Override
    public Attorney findByUsername(String username) {
        return attorneyRepository.findByUsername(username);
    }
}
