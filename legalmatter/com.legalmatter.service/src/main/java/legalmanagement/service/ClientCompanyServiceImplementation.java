package legalmanagement.service;

import legalmanagement.data.dao.ClientCompanyDao;
import legalmanagement.data.entity.ClientCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientCompanyServiceImplementation implements ClientCompanyService {

    private ClientCompanyDao clientCompanyDao;

    @Autowired
    public ClientCompanyServiceImplementation(ClientCompanyDao theClientCompanyDao){
        clientCompanyDao = theClientCompanyDao;
    }

    @Override
    @Transactional

    public List<ClientCompany> findAll() {
        return clientCompanyDao.findAll();
    }

    @Override
    @Transactional

    public ClientCompany findClientCompanyById(int theId) {
        return clientCompanyDao.findClientCompanyById(theId);
    }

    @Override
    @Transactional

    public void saveClientCompany(ClientCompany theClientCompany) {
        clientCompanyDao.saveClientCompany(theClientCompany);
    }

    @Override
    @Transactional

    public void deleteClientCompanyById(int theId) {
        clientCompanyDao.deleteClientCompanyById(theId);
    }
}
