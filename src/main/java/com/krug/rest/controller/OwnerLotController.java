package com.krug.rest.controller;

import com.krug.rest.model.Owner;
import com.krug.rest.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ownerlot")
public class OwnerLotController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/ownerInfo")
    public List<Owner> getAllOwner(){
        return  ownerService.getAllOwner();
    }

    @PostMapping("/owner")
    public  String owner(@Valid @RequestBody Owner ownerDTO){
    return ownerService.owner(ownerDTO);
    }

}
