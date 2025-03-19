package com.airbnbclone.airbnbclone.Service;

import com.airbnbclone.airbnbclone.Entity.Booking;
import com.airbnbclone.airbnbclone.Entity.Property;
import com.airbnbclone.airbnbclone.Repository.BookingRepository;
import com.airbnbclone.airbnbclone.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    /**
     * params propertyID
     * params startDate
     * params endDate
     * return param booking object
     */

    public Booking createBooking(Long propertyId, LocalDate startDate, LocalDate endDate) {
        Property property = propertyRepository.findById(propertyId).orElseThrow(() -> new RuntimeException("Property Not Found"));
        Booking booking = new Booking();
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setProperty(property);
        return bookingRepository.save(booking);
    }

    // get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // get booking by property id
    public List<Booking> getBookingByPropertyId(Long propertyId) {
        return bookingRepository.findByPropertyId(propertyId);
    }

    // delete
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
