package legalmanagement.data.Repository;

import legalmanagement.data.entity.Attorney;
import legalmanagement.data.entity.ClientCompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCompanyRepository extends JpaRepository<ClientCompany, Long> {

    public List<ClientCompany> findAll();

    public ClientCompany findClientCompanyById(long theId);

    public void saveClientCompany(ClientCompany theClientCompany);

    public void deleteClientCompanyById(long theId);

}
