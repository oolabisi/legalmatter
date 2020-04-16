package legalmanagement.service;

import legalmanagement.data.entity.Client;

import java.util.List;

public interface ClientService {

    public List<Client> findAll();

    public Client findClientById(int theId);

    public void saveClient(Client theClient);

    public void deleteClientById(int theId);
}
