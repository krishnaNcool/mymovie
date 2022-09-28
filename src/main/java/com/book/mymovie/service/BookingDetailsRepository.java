package com.book.mymovie.service;

import com.book.mymovie.entity.BookingDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetailsEntity, Integer> {
}
