package legalmanagement.rest;

import legalmanagement.data.Repository.ClientCompanyRepository;
import legalmanagement.data.entity.ClientCompany;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/legalmatter")
public class ClientCompanyController {

    private ClientCompanyRepository clientCompany;

    // class constructor

    public ClientCompanyController(ClientCompanyRepository theClientCompany){
        clientCompany = theClientCompany;
    }
    // exposing and returning the attorney

    @GetMapping("/clientcompanies")
    public List<ClientCompany> findAll(){
        return clientCompany.findAll();
    }

    //exposing and returning an Client by its Id

    @GetMapping("/clientcompanies/{clientcompanyId}")
    public ClientCompany getClientCompany(@PathVariable int clientCompanyId){

        ClientCompany theClientCompany = clientCompany.findClientCompanyById(clientCompanyId);

        if (theClientCompany == null){
            throw new RuntimeException("ClientCompany id not found :" + clientCompanyId);
        }
        return theClientCompany;
    }

    // method to add an ClientCompany ()

    @PostMapping("/clientcompanies")
    public ClientCompany add(@RequestBody ClientCompany theClientCompany){

        //(Just incase an Id is passed in json set Id to 0,
        // this is to force a save of new item instead of update)
//        theClientCompany.setClientCompanyId(0);

        clientCompany.saveClientCompany(theClientCompany);

        return theClientCompany;
    }

    // method to update an existing Client
    @PutMapping("/clientCompanies")
    public ClientCompany updateClientCompany(@RequestBody ClientCompany theClientCompany){

        clientCompany.saveClientCompany(theClientCompany);

        return theClientCompany;
    }

    // method to delete a Client
    @DeleteMapping("/clientCompany/{clientCompanyId}")
    public String deleteClientCompany(@PathVariable int clientCompanyId){
        ClientCompany tempClientCompany  = clientCompany.findClientCompanyById(clientCompanyId);

        //
        if (tempClientCompany == null){
            throw new RuntimeException("Client id not found : " + clientCompanyId);
        }
        clientCompany.deleteClientCompanyById(clientCompanyId);
        return "Deleted clientCompany id " + clientCompanyId;
    }
}
