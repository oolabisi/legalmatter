package legalmanagement.rest;

import legalmanagement.data.Repository.LawFirmRepository;
import legalmanagement.data.entity.LawFirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/legalmanagement")
public class LawFirmController {
    private LawFirmRepository lawFirmService;

    // class constructor
    @Autowired
    public LawFirmController(LawFirmRepository theLawFirmService) {
        lawFirmService = theLawFirmService;
    }

    // exposing and returning the attorney

    @GetMapping("/lawfirm")
    public List<LawFirm> findAll(){
        return lawFirmService.findAll();
    }

    //exposing and returning a Lawfirm by its Id

    @GetMapping("/lawfirm/{lawfirmId}")
    public Optional<LawFirm> getLawFirm(@PathVariable Long lawFirmId){

        Optional<LawFirm> theLawFirm = lawFirmService.findById(lawFirmId);

        if (theLawFirm == null){
            throw new RuntimeException("Lawfirm id not found :" + lawFirmId);
        }
        return theLawFirm;
    }

    // method to add a Lawfirm ()

    @PostMapping("/lawfirm")
    public LawFirm add(@RequestBody LawFirm theLawFirm){

        //(Just incase an Id is passed in json set Id to 0,
        // this is to force a save of new item instead of update)
//        theLawFirm.setLawFirmId(0);

        lawFirmService.save(theLawFirm);

        return theLawFirm;
    }

    // method to update an existing Lawfirm
    @PutMapping("/Lawfirm")
    public LawFirm updateLawFirm(@RequestBody LawFirm theLawFirm){

        lawFirmService.save(theLawFirm);

        return theLawFirm;
    }

    // method to delete a Lawfirm
    @DeleteMapping("/lawfirm/{lawfirmId}")
    public String deleteLawFirm(@PathVariable Long lawFirmId){
        Optional<LawFirm> tempLawFirm  = lawFirmService.findById(lawFirmId);

        //
        if (tempLawFirm == null){
            throw new RuntimeException("LawFirm id not found : " + lawFirmId);
        }
        lawFirmService.deleteById(lawFirmId);
        return "Deleted lawfirm id " + lawFirmId;
    }
}
