package com.example.RenterrAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyDAO {

    @Autowired
    PropertyRepository propertyRepository;

//    Save a Property
    public Property save(Property property){
        return propertyRepository.save(property);
    }

//    Search all Properties
    public List<Property> findAll(){
        return propertyRepository.findAll();
    }

//    Get a Property by id
    public Property findOne(Long id){
        return propertyRepository.getOne(id);
    }

//    Delete a Property
    public void delete(Property property){
        propertyRepository.delete(property);
    }

}
