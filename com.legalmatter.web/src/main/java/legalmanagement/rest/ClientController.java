package legalmanagement.rest;

import legalmanagement.data.Repository.ClientRepository;
import legalmanagement.data.entity.Client;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.List;

@RestController
@RequestMapping("/legalmanagement")
public class ClientController {
    private ClientRepository clientService;

    // class constructor

    public ClientController(ClientRepository theClientService){
        clientService = theClientService;
    }

    // exposing and returning all the Client on the List

    @GetMapping("/clients")
    public List<Client> findAll(){
        return clientService.findAll();
    }

    //exposing and returning an Client by its Id

    @GetMapping("/clients/{clientId}")
    public Client getClient(@PathVariable int clientId){

        Client theClient = clientService.findClientById(clientId);

        if (theClient == null){
            throw new RuntimeException("Client id not found :" + clientId);
        }
        return theClient;
    }

    // method to add an Client ()

    @PostMapping("/clients")
    public Client add(@RequestBody Client theClient){

        //(Just incase an Id is passed in json set Id to 0,
        // this is to force a save of new item instead of update)
//        theClient.setClientId(0);

        clientService.saveClient(theClient);

        return theClient;
    }

    // method to update an existing Client
    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client theClient){

        clientService.saveClient(theClient);

        return theClient;
    }

    // method to delete a Client
    @DeleteMapping("/clients/{clientId}")
    public String deleteClient(@PathVariable int clientId){
        Client tempClient  = clientService.findClientById(clientId);

        // throw an exception...
        if (tempClient == null){
            throw new RuntimeException("Client id not found : " + clientId);
        }
        clientService.deleteClientById(clientId);
        return "Deleted client id " + clientId;
    }
}
