package legalmanagement.data.dao;

import legalmanagement.data.entity.ClientCompany;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;


@Repository
public class ClientCompanyDaoImplementation implements ClientCompanyDao {

    private EntityManager entityManager;

    // implementation Constructor

    @Autowired

    public ClientCompanyDaoImplementation(EntityManager theEntityManager){

        entityManager = theEntityManager;
    }

    @Override

    public List<ClientCompany> findAll() {
        Session cSession = entityManager.unwrap(Session.class);

        Query<ClientCompany> theQuery = cSession.createQuery("theClientCompany",ClientCompany.class);

        List<ClientCompany> theClientCompany = theQuery.getResultList();

        return theClientCompany;
    }

    @Override
    // method to find a Clientcompany from the List
    public ClientCompany findClientCompanyById(int theId) {

        Session session = entityManager.unwrap(Session.class);

        ClientCompany requestedCompany = session.find(ClientCompany.class, theId);

        return requestedCompany;
   }

    @Override
    // method to save a ClientCompany to the List
    public void saveClientCompany(ClientCompany theClientCompany) {

        Session cSession = entityManager.unwrap(Session.class);

        cSession.saveOrUpdate(theClientCompany);
    }

    @Override

    // method to delete a ClientCompany from the List
    public void deleteClientCompanyById(int theId) {

        Session cSession = entityManager.unwrap(Session.class);

        Query theQuery = cSession.createQuery("delete from ClientCompany where id=:clientCompanyId");

        theQuery.setParameter("clientCompanyId", theId);

        theQuery.executeUpdate();
    }
}
