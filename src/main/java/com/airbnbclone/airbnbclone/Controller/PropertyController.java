package com.airbnbclone.airbnbclone.Controller;

import com.airbnbclone.airbnbclone.Entity.Property;
import com.airbnbclone.airbnbclone.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    /**
     * createProperty:
     * Handles POST requests to create a new property.
     * Expects a property object in the request body and a userId as a request parameter.
     * getPropertyById:
     * Handles Get requests to retrieve a property by ID.
     * Returns a 404 response if the property is not found.
     * getAllProperties:
     * Handles GET requests to retrieve all properties
     *
     * @param property
     * @param userId
     * @return
     */

    // create a post mapping
    @PostMapping
    public Property createProperty(@RequestBody Property property,
                                   @RequestParam Long userId) {
        return propertyService.createProperty(property, userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getPropertyById(id);
        return ResponseEntity.ok(property);
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperty();
    }
}
