package legalmanagement.rest;

import legalmanagement.data.Repository.ClientRepository;
import legalmanagement.data.entity.ClientCompany;
import legalmanagement.data.Repository.ClientCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping
public class ClientCompanyController {

    @Autowired
    ClientRepository clientRepository;
    ClientCompanyRepository clientCompanyRepository;

    // class constructor

    public ClientCompanyController(ClientCompanyRepository theClientCompany){
        clientCompanyRepository = theClientCompany;
    }
    // exposing and returning the attorney

    @GetMapping("/clients/{clientId}/clientcompanies")
    public Page getAllCompanyByClientId(@PathVariable(value = "clientId") Long clientId, Pageable pageable){

        return clientCompanyRepository.findByClientId(clientId, pageable);
    }

    //exposing and returning an Client by its Id

    @GetMapping("/clientcompanies/{clientcompanyId}")
    public Optional<ClientCompany> getClientCompany(@PathVariable Long clientCompanyId){

        Optional<ClientCompany> theClientCompany = clientCompanyRepository.findById(clientCompanyId);

        if (theClientCompany == null){
            throw new RuntimeException("ClientCompany id not found :" + clientCompanyId);
        }
        return theClientCompany;
    }

    // method to add an ClientCompany ()
    @PostMapping("/clients/{clientId}/clientcompanies")
    public ClientCompany add(@PathVariable (value = "clientId") Long clientId, @Valid @RequestBody
            ClientCompany theClientCompany){

       /* //(Just incase an Id is passed in json set Id to 0,
        // this is to force a save of new item instead of update)
//        theClientCompany.setClientCompanyId(0);
        clientCompany.save(theClientCompany);
*/
        return clientRepository.findById(clientId).map(client -> { theClientCompany.setClient(client);
            return (ClientCompany) clientCompanyRepository.save(theClientCompany);
        })
                .orElseThrow(() -> new ResourceNotFoundException("ClientId " + clientId + "not found"));
        }


    // method to update an existing Client
    @PutMapping("/clients/{clientId}/clientCompanies/{clientCompaniesId}")
    public ClientCompany updateClientCompany(@PathVariable (value = "clientId") Long clientId,
                                             @PathVariable (value = "clientCompanyId") Long clientCompanyId,
                                             @Valid @RequestBody ClientCompany theClientCom) {

        if(!clientRepository.existsById(clientId)){
            throw new ResourceNotFoundException(("ClientId" + clientId + "not found"));
           }
        return clientCompanyRepository.findById(clientCompanyId).map(company -> {
            company.setCompanyName(theClientCom.getCompanyName());
            return clientCompanyRepository.save(company);
        })
                .orElseThrow(() -> new ResourceNotFoundException(("clientCompanyId" + clientCompanyId + "not found")));
    }

    // method to delete a Client
    @DeleteMapping("/clientCompany/{clientCompanyId}")
    public ResponseEntity<?> deleteClientCompany(@PathVariable (value = "clientId") Long clientId,
                                                 @PathVariable (value = "clientCompanyId") Long clientCompanyId){
        return clientCompanyRepository.findByIdAndClientId(clientCompanyId, clientId).map(company -> {
            clientCompanyRepository.delete(company);
          return ResponseEntity.ok().build();
        })
                .orElseThrow(() -> new ResourceNotFoundException(("ClientCompany not found with id " + clientCompanyId
                        + "clientId" + clientId)));
    }

       /* Optional<ClientCompany> tempClientCompany  = clientCompany.findById(clientCompanyId);

        //
        if (tempClientCompany == null){
            throw new RuntimeException("Client id not found : " + clientCompanyId);
        }
        clientCompany.deleteById(clientCompanyId);
        return "Deleted clientCompany id " + clientCompanyId;
    */
}

