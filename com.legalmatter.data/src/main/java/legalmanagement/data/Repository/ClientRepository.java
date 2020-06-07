package legalmanagement.data.Repository;

import legalmanagement.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

   Optional<Client> findByEmail(String email);
/*
    Client findByVerificationToken(String verificationToken);
*/

}
