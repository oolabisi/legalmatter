package legalmanagement.rest;

import legalmanagement.data.Repository.ClientCompanyRepository;
import legalmanagement.data.entity.ClientCompany;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/legalmanagement")
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
    public Optional<ClientCompany> getClientCompany(@PathVariable Long clientCompanyId){

        Optional<ClientCompany> theClientCompany = clientCompany.findById(clientCompanyId);

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

        clientCompany.save(theClientCompany);

        return theClientCompany;
    }

    // method to update an existing Client
    @PutMapping("/clientCompanies")
    public ClientCompany updateClientCompany(@RequestBody ClientCompany theClientCompany){

        clientCompany.save(theClientCompany);

        return theClientCompany;
    }

    // method to delete a Client
    @DeleteMapping("/clientCompany/{clientCompanyId}")
    public String deleteClientCompany(@PathVariable Long clientCompanyId){
        Optional<ClientCompany> tempClientCompany  = clientCompany.findById(clientCompanyId);

        //
        if (tempClientCompany == null){
            throw new RuntimeException("Client id not found : " + clientCompanyId);
        }
        clientCompany.deleteById(clientCompanyId);
        return "Deleted clientCompany id " + clientCompanyId;
    }
}
