package legalmanagement.data.Repository;

import legalmanagement.data.entity.ClientCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientCompanyRepository extends JpaRepository<ClientCompany, Long> {

    Page findByClientId(Long clientId, Pageable pageable);

    Optional<ClientCompany> findByIdAndClientId(Long clientCompanyId, Long clientId);

}
