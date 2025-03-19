package com.airbnbclone.airbnbclone.Repository;

import com.airbnbclone.airbnbclone.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
