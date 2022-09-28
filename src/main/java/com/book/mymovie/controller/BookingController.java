package com.book.mymovie.controller;


import com.book.mymovie.entity.BookingDetailsEntity;
import com.book.mymovie.entity.BookingEntity;
import com.book.mymovie.entity.UserEntity;
import com.book.mymovie.exception.BookingNotFoundException;
import com.book.mymovie.model.UserRole;
import com.book.mymovie.repository.BookingRepository;
import com.book.mymovie.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingRepository repository;
    private final UserService service;

    @GetMapping("{id}")
    public BookingEntity findById(@PathVariable final int id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking with id: " + id + " not found."));
    }

    @GetMapping("all")
    public List<BookingEntity> allBookings() {
        final UserEntity user = service.getLoggedInUser();
        if (user.getUserRole().equals(UserRole.ROLE_ADMIN) || user.getUserRole().equals(UserRole.ROLE_SUPER_ADMIN))
            return repository.findAll();
        else return repository.findAllByUserIdOrderByBookedOnAsc(user.getId());
    }

    @GetMapping("{username}/all")
    public List<BookingEntity> findAllByUserId(@PathVariable String username) {
        if (!(username.contains("-") && username.length() > 10))
            username = service.getUser(username).getId();
        return repository.findAllByUserIdOrderByBookedOnAsc(username);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBooking(@PathVariable final int id) {
        repository.deleteById(id);
    }

    @GetMapping("{id}/details")
    public BookingDetailsEntity findByDetailsId(@PathVariable final int id) {
        return this.findById(id).getBookingDetails();
    }
}
