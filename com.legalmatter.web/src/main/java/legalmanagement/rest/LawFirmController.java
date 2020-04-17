package legalmanagement.rest;

import legalmanagement.data.entity.LawFirm;
import legalmanagement.service.LawFirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/legalmatter")
public class LawFirmController {

    private LawFirmService lawFirmService;

    // class constructor
    @Autowired
    public LawFirmController(LawFirmService theLawFirmService) {
        lawFirmService = theLawFirmService;
    }

    // exposing and returning the attorney

    @GetMapping("/lawfirm")
    public List<LawFirm> findAll(){
        return lawFirmService.findAll();
    }

    //exposing and returning a Lawfirm by its Id

    @GetMapping("/lawfirm/{lawfirmId}")
    public LawFirm getLawFirm(@PathVariable int lawFirmId){

        LawFirm theLawFirm = lawFirmService.findLawFirmById(lawFirmId);

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
        theLawFirm.setLawFirmId(0);

        lawFirmService.saveLawFirm(theLawFirm);

        return theLawFirm;
    }

    // method to update an existing Lawfirm
    @PutMapping("/Lawfirm")
    public LawFirm updateLawFirm(@RequestBody LawFirm theLawFirm){

        lawFirmService.saveLawFirm(theLawFirm);

        return theLawFirm;
    }

    // method to delete a Lawfirm
    @DeleteMapping("/lawfirm/{lawfirmId}")
    public String deleteLawFirm(@PathVariable int lawFirmId){
        LawFirm tempLawFirm  = lawFirmService.findLawFirmById(lawFirmId);

        //
        if (tempLawFirm == null){
            throw new RuntimeException("LawFirm id not found : " + lawFirmId);
        }
        lawFirmService.deleteLawFirmById(lawFirmId);
        return "Deleted lawfirm id " + lawFirmId;
    }
}
