package legalmanagement.data.dao;

import legalmanagement.data.entity.LawFirm;

import java.util.List;

public interface LawFirmDao {

    public List<LawFirm> findAll();

    public LawFirm findLawFirmById(int theId);

    public void saveLawFirm(LawFirm theLawFirm);

    public void deleteLawFirmById(int theId);

}
