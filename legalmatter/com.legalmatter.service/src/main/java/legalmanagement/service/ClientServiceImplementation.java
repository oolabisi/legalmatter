package legalmanagement.service;

import legalmanagement.data.dao.ClientDao;
import legalmanagement.data.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplementation implements ClientService {

    private ClientDao clientDao;

    @Autowired
    public ClientServiceImplementation(ClientDao theClientDao){
        clientDao = theClientDao;
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findClientById(int theId) {
        return clientDao.findClientById(theId);
    }

    @Override
    public void saveClient(Client theClient) {
        clientDao.saveClient(theClient);
    }

    @Override
    public void deleteClientById(int theId) {
        clientDao.deleteClientById(theId);
    }
}
