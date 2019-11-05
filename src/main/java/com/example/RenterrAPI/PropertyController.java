package com.example.RenterrAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyDAO propertyDAO;

    //New Code
    @GetMapping("/properties")
    public String getProperties(@RequestParam(value = "address") String address){
//        Property property = propertyDAO.findByAddress(address);
//
//        if (address == null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(property);
        return "get properties was called with address = "+address;
    }

    //Save a Property
    @PostMapping("/properties")
    public Property createPropertyListing(@Valid @RequestBody Property property){
        return propertyDAO.save(property);
    }

    //Get All Properties
    @GetMapping("/properties")
    public List<Property> getAllProperties(){
        return propertyDAO.findAll();
    }

    //Get Property by ID
    @GetMapping("/properties/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable(value = "id") Long id){
        Property property = propertyDAO.findOne(id);

        if (id == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(property);
    }


    //Update Property by id
    @PutMapping("/properties/{id}")
    public ResponseEntity<Property> updateProperty
    (@PathVariable(value = "id") Long id, @Valid @RequestBody Property propertyDetails){
        Property property = propertyDAO.findOne(id);
        if (id == null){
            return ResponseEntity.notFound().build();
        }
        property.setAddress(propertyDetails.getAddress());
        property.setPropertyType(propertyDetails.getPropertyType());
        property.setNumBathrooms(propertyDetails.getNumBathrooms());
        property.setNumBedrooms(propertyDetails.getNumBedrooms());
        property.setNumGarages(propertyDetails.getNumGarages());

        Property updateProperty = propertyDAO.save(property);
        return ResponseEntity.ok().body(updateProperty);
    }

    //Delete Property by id
    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Property> deleteProperty(@PathVariable(value = "id") Long id){
        Property property = propertyDAO.findOne(id);

        if (id == null){
            return ResponseEntity.notFound().build();
        }

        propertyDAO.delete(property);

        return ResponseEntity.ok().build();

    }
}
