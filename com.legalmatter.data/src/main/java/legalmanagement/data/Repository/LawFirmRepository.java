package legalmanagement.data.Repository;

import legalmanagement.data.entity.LawFirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawFirmRepository extends JpaRepository<LawFirm, Long> {

}
