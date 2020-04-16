package legalmanagement.data.dao;

import legalmanagement.data.entity.LawFirm;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class LawFirmDaoImplementation implements LawFirmDao {

    private EntityManager entityManager;

    // implementation Constructor

    @Autowired

    public LawFirmDaoImplementation(EntityManager theEntityManager){

        entityManager = theEntityManager;
    }

    @Override

    // method to get all LawFirms from the List
    public List<LawFirm> findAll() {
        Session cSession = entityManager.unwrap(Session.class);

        Query<LawFirm> theQuery = cSession.createQuery("LawFirms", LawFirm.class);

        List<LawFirm> allLawFirms = theQuery.getResultList();

        return allLawFirms;
    }

    // method to find a LawFirm from the List
    public LawFirm findLawFirmById(int theId) {

        Session session = entityManager.unwrap(Session.class);

        LawFirm requestedFirm = session.find(LawFirm.class, theId);

        return requestedFirm;
    }

    @Override
    // method to save a LawFirm to the List
    public void saveLawFirm(LawFirm theLawFirm) {

        Session cSession = entityManager.unwrap(Session.class);

        cSession.saveOrUpdate(theLawFirm);
    }

    @Override

    // method to delete a LawFirm from the List

    public void deleteLawFirmById(int theId) {

        Session cSession = entityManager.unwrap(Session.class);

        Query theQuery = cSession.createQuery("delete from LawFirm where id=:lawFirmId");

        theQuery.setParameter("lawFirmId", theId);

        theQuery.executeUpdate();
    }
}
