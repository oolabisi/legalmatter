package legalmanagement.service;


import legalmanagement.data.dao.AttorneyDao;
import legalmanagement.data.entity.Attorney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttorneyServiceImplementation implements AttorneyService {

    private AttorneyDao attorneyDao;

    @Autowired
    public AttorneyServiceImplementation(AttorneyDao theAttorneyDao){
        attorneyDao = theAttorneyDao;
    }

    @Override
    @Transactional

    public List<Attorney>findAll() {
        return attorneyDao.findAll();
    }

    @Override
    @Transactional
    public Attorney findAttorneyById(int theId) {
        return attorneyDao.findAttorneyById(theId);
    }

    @Override
    @Transactional
    public void saveAttorney(Attorney theAttorney) {
        attorneyDao.saveAttorney(theAttorney);
    }

    @Override
    @Transactional
    public int deleteAttorneyById(int theId) {
        attorneyDao.deleteAttorneyById(theId);
        return theId;
    }
}