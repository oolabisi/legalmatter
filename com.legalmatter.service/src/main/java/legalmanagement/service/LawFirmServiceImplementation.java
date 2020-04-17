package legalmanagement.service;

import legalmanagement.data.dao.LawFirmDao;
import legalmanagement.data.entity.LawFirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LawFirmServiceImplementation implements LawFirmService {

    private LawFirmDao lawFirmDao;

    @Autowired
    public LawFirmServiceImplementation(LawFirmDao theLawFirmDao){
        lawFirmDao = theLawFirmDao;
    }

    @Override
    @Transactional
    public List<LawFirm> findAll() {
        return lawFirmDao.findAll();
    }

    @Override
    @Transactional
    public LawFirm findLawFirmById(int theId) {
        return lawFirmDao.findLawFirmById(theId);
    }

    @Override
    @Transactional
    public void saveLawFirm(LawFirm theLawFirm) {
        lawFirmDao.saveLawFirm(theLawFirm);
    }

    @Override
    @Transactional
    public void deleteLawFirmById(int theId) {
        lawFirmDao.deleteLawFirmById(theId);
    }
}
