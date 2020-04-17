package legalmanagement.data.dao;

import legalmanagement.data.entity.ClientCompany;

import java.util.List;

public interface ClientCompanyDao {

    public List<ClientCompany> findAll();

    public ClientCompany findClientCompanyById(int theId);

    public void saveClientCompany(ClientCompany theClientCompany);

    public void deleteClientCompanyById(int theId);


}
