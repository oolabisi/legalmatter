package legalmanagement.rest;


import legalmanagement.data.entity.Attorney;
import legalmanagement.service.AttorneyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attorney")
public class AttorneyController {

    private AttorneyService attorneyService;

    // Constructor
    public AttorneyController(AttorneyService theAttorneyService){
        attorneyService = theAttorneyService;
    }

    @GetMapping("/attorney")
    public List<Attorney> findAll(){
        return attorneyService.findAll();
    }

    //exposing and returning an Client by its Id

    @GetMapping("/attorney/{attorneyId}")
    public Attorney getAttorney(@PathVariable int attorneyId) {
        Attorney theAttorney = attorneyService.findAttorneyById(attorneyId);
        if (theAttorney == null) {
            throw new RuntimeException("Attorney id is not found: " + attorneyId);
        }
        return theAttorney;
    }

    // method to add an ClientCompany ()

    @PostMapping("/attorney")
    public Attorney get(@RequestBody Attorney theAttorney){

        //(Just incase an Id is passed in json set Id to 0,
        // this is to force a save of new item instead of update)
        theAttorney.setAttorneyId(0);
        attorneyService.saveAttorney(theAttorney);
        return theAttorney;
    }

    // method to update an existing Client

    @PutMapping("attorney")
    public Attorney updateAttorney(@RequestBody Attorney theAttorney){
        attorneyService.saveAttorney(theAttorney);
        return theAttorney;
    }

    // method to delete a Client

    @DeleteMapping("/attorney/{attorneyId}")
    public String deleteAttorney(@PathVariable int attorneyId){
        Attorney tempAttorney = attorneyService.findAttorneyById(attorneyId);
        if (tempAttorney == null){
            throw new RuntimeException("Attorney id cannot be found: "+ attorneyId);
        }
        attorneyService.deleteAttorneyById(attorneyId);
        return "Deleted Attorney id: "+ attorneyId;
    }
}