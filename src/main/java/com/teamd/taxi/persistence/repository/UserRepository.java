package com.teamd.taxi.persistence.repository;

import com.teamd.taxi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Slava on 21.04.2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {}
