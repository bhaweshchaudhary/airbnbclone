package com.airbnbclone.airbnbclone.Controller;

import com.airbnbclone.airbnbclone.Entity.Booking;
import com.airbnbclone.airbnbclone.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * createBooking:
     * Take the property ID, startDate, and endDate as parameters.
     * Fetches the Property from the repository.
     * Creates a new Booking object, sets its properties, and saves it in the repository.
     * getBookingById:
     * Retrieves a booking by its ID from the repository.
     * getAllBookings:
     * Returns a list of all bookings.
     * getBookingsByProperty:
     * Retrieves all bookings associated with a specific property.
     * deleteBooking:
     * Deletes a booking by its ID after verifying its existence.
     *
     * @param propertyId
     * @param startDate
     * @param endDate
     * @return
     */

    @PostMapping
    public Booking createBooking(@RequestParam Long propertyId,
                                 @RequestParam LocalDate startDate,
                                 @RequestParam LocalDate endDate) {
        return bookingService.createBooking(propertyId, startDate, endDate);
    }

    @GetMapping("/{id")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/property/{propertyId")
    public List<Booking> getBookingByPropertyId(@PathVariable Long propertyId) {
        return bookingService.getBookingByPropertyId(propertyId);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}
