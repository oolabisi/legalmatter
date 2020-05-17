package legalmanagement.data.Repository;

import legalmanagement.data.entity.ClientCompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientCompanyRepository extends JpaRepository<ClientCompany, Long> {

}
