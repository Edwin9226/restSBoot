package com.krug.rest.service;

import com.krug.rest.model.Owner;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OwnerService {

   List<Owner> getAllOwner();
   String owner (Owner ownerDto);
   ResponseEntity<?> unOwner(Long id);

}
