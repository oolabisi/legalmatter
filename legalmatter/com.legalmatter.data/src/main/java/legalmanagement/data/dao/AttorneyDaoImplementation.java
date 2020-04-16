package legalmanagement.data.dao;

import legalmanagement.data.entity.Attorney;
import legalmanagement.data.entity.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AttorneyDaoImplementation implements AttorneyDao {

    private EntityManager entityManager;

    // Constructor

    @Autowired

    public AttorneyDaoImplementation(EntityManager theEntityManager){

        entityManager = theEntityManager;
    }

    // method to find all the Attorney on the List
    @Override
    public List<Attorney> findAll() {

        Session cSession = entityManager.unwrap(Session.class);

        Query<Attorney> theQuery = cSession.createQuery("theAttorney",Attorney.class);

        List<Attorney> theAttorney = theQuery.getResultList();

        return theAttorney;
    }

    // Method to Find an Attorney
    @Override
    public Attorney findAttorneyById(int theId) {

        Session session = entityManager.unwrap(Session.class);

        Attorney requestedAttorney = session.find(Attorney.class, theId);


        return requestedAttorney;
    }

    // method to Save/Update an Attorney on the List
    @Override
    public void saveAttorney(Attorney theAttorney) {

        Session cSession = entityManager.unwrap(Session.class);

        cSession.saveOrUpdate(theAttorney);

    }

    // method to delete an Attorney from the List
    @Override
    public void deleteAttorneyById(int theId) {

        Session cSession = entityManager.unwrap(Session.class);

        Query theQuery = cSession.createQuery("delete from Attorney where id=:attorneyId");

        theQuery.setParameter("attorneyId", theId);

        theQuery.executeUpdate();
    }
}
