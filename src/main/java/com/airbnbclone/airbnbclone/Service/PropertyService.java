package com.airbnbclone.airbnbclone.Service;

import com.airbnbclone.airbnbclone.Entity.Property;
import com.airbnbclone.airbnbclone.Entity.User;
import com.airbnbclone.airbnbclone.Repository.PropertyRepository;
import com.airbnbclone.airbnbclone.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    public Property createProperty(Property property, Long userId) {
        User owner = userRepository.findById(userId).
                orElseThrow(()-> new RuntimeException("User not found"));
        property.setOwner(owner);
        return propertyRepository.save(property);
    }

    // get property by user id

     public Property getPropertyById(Long propertyId) {
        return propertyRepository.findById(propertyId).orElseThrow(()-> new RuntimeException("Property not found"));
     }

     public List<Property> getAllProperty() {
        return propertyRepository.findAll();
     }

}
