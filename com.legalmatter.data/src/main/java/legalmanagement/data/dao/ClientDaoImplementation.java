package legalmanagement.data.dao;

import legalmanagement.data.entity.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class ClientDaoImplementation implements ClientDao {

    private EntityManager entityManager;

    // implementation Constructor

    @Autowired

    public ClientDaoImplementation(EntityManager theEntityManager){

        entityManager = theEntityManager;
    }

    @Override

    // method to find all the clients from the List
    public List<Client> findAll() {
        Session cSession = entityManager.unwrap(Session.class);

        Query<Client> theQuery = cSession.createQuery("theClient",Client.class);

        List<Client> theClient = theQuery.getResultList();

        return theClient;
    }

    // method to find a Client from the List
    public Client findClientById(int theId) {

        Session session = entityManager.unwrap(Session.class);

        Client requestedClient = session.find(Client.class, theId);

        return requestedClient;
    }

    @Override
    // method to save a Client to the List
    public void saveClient(Client theClient) {

        Session cSession = entityManager.unwrap(Session.class);

        cSession.saveOrUpdate(theClient);
    }

    @Override

    // method to delete a Client from the List
    public void deleteClientById(int theId) {

        Session cSession = entityManager.unwrap(Session.class);

        Query theQuery = cSession.createQuery("delete from Client where id=:clientId");

        theQuery.setParameter("clientId", theId);

        theQuery.executeUpdate();
    }
}
