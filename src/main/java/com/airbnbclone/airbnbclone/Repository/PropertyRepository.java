package com.airbnbclone.airbnbclone.Repository;

import com.airbnbclone.airbnbclone.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
