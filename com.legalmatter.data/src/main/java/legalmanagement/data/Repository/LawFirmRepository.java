package legalmanagement.data.Repository;

import legalmanagement.data.entity.LawFirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LawFirmRepository extends JpaRepository<LawFirm, Long> {

    public List<LawFirm> findAll();

    public LawFirm findLawFirmById(long theId);

    public void saveLawFirm(LawFirm theLawFirm);

    public void deleteLawFirmById(long theId);

}
