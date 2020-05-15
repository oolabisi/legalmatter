package legalmanagement.data.Repository;

import legalmanagement.data.entity.Attorney;
import legalmanagement.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    public List<Client> findAll();

    public Client findClientById(long theId);

    public void saveClient(Client theClient);

    public void deleteClientById(long theId);

}
