package com.airbnbclone.airbnbclone.Repository;

import com.airbnbclone.airbnbclone.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
