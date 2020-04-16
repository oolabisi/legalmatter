package legalmanagement.service;

import legalmanagement.data.entity.ClientCompany;

import java.util.List;

public interface ClientCompanyService {

    public List<ClientCompany> findAll();

    public ClientCompany findClientCompanyById(int theId);

    public void saveClientCompany(ClientCompany theClientCompany);

    public void deleteClientCompanyById(int theId);
}
