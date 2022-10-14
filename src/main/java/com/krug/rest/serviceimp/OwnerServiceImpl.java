package com.krug.rest.serviceimp;

import com.krug.rest.exception.ResourceNotFoundException;
import com.krug.rest.model.Owner;
import com.krug.rest.model.User;
import com.krug.rest.repositry.OwnerRepository;
import com.krug.rest.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository ownerRepository;
    @Override
    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }

    @Override
    public String owner(Owner ownerDto) {
        if (ownerDto.getOwnerid() >0) {
            ownerRepository.save(ownerDto);
        }else {
            throw new RuntimeException("No se encuentra propietario");
        }
        return "Ownerd" ;
    }

    @Override
    public ResponseEntity<?> unOwner(Long ownerId) {
        return ownerRepository.findById(ownerId) .map(owner -> {
            ownerRepository.delete(owner);
            return  ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Owner not found with id"+ ownerId));
    }

}
