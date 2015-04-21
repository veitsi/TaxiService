package com.teamd.taxi.persistence.service.Impl;

import com.teamd.taxi.entity.User;
import com.teamd.taxi.persistence.repository.UserRepository;
import com.teamd.taxi.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Slava on 21.04.2015.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public User find(long id) {
        return userRepository.findOne(id);
    }
}
