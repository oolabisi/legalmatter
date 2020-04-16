package legalmanagement.data.dao;

import legalmanagement.data.entity.Client;

import java.util.List;

public interface ClientDao {

    public List<Client> findAll();

    public Client findClientById(int theId);

    public void saveClient(Client theClient);

    public void deleteClientById(int theId);

}
