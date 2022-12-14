package com.book.mymovie.repository;

import com.book.mymovie.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(final String email);

    Optional<UserEntity> findByMobile(final String mobile);
}
