package legalmanagement.service;

import legalmanagement.data.entity.Attorney;

public interface UserService {
    void save(Attorney user);

    Attorney findByUsername(String username);
}
