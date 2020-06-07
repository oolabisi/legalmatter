package legalmanagement.rest;

import legalmanagement.data.Repository.ClientRepository;
import legalmanagement.data.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ClientController {

    @Autowired
    ClientRepository clientService;

    // class constructor
    public ClientController(ClientRepository theClientService){
        clientService = theClientService;
    }

    // exposing and returning all the Client on the List

    @GetMapping("/clients")
    public List<Client> getAllClients() {

        return clientService.findAll();
    }

    //exposing and returning an Client by its Id

    @GetMapping("/clients/{clientId}")
    public Optional<Client> getClient(@PathVariable Long clientId){

        Optional<Client> theClient = clientService.findById(clientId);

        if (theClient == null){
            throw new RuntimeException("Client id not found :" + clientId);
        }
        return theClient;
    }

    // method to add an Client ()

    @PostMapping("/clients")
    public Client add(@Valid @RequestBody Client theClient){

        //(Just incase an Id is passed in json set Id to 0,
        // this is to force a save of new item instead of update)
//        theClient.setClientId(0);

        clientService.save(theClient);
        return theClient;
    }

    // method to update an existing Client
    @PutMapping("/clients")
    public Client updateClient(@PathVariable Long clientId, @Valid @RequestBody Client theClient){

        //clientService.save(theClient);

        return clientService.findById(clientId).map(client -> {
            client.setFirstName(theClient.getFirstName());
            return clientService.save(client);
        })
                .orElseThrow(()-> new ResourceNotFoundException("ClientId" + clientId + "not found"));
    }

    // method to delete a Client
    @DeleteMapping("/clients/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId){
       return clientService.findById(clientId).map(client -> {
           clientService.delete(client);
           return ResponseEntity.ok() .build();
       })
               .orElseThrow(()-> new ResourceNotFoundException("ClientId" + clientId + "not found"));


        //Optional<Client> tempClient  = clientService.findById(clientId);

        // throw an exception...
        /*if (tempClient == null){
            throw new RuntimeException("Client id not found : " + clientId);
        }
        clientService.deleteById(clientId);
        return "Deleted client id " + clientId;*/
    }
}
