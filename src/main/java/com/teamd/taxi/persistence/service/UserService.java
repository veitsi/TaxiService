package com.teamd.taxi.persistence.service;

import com.teamd.taxi.entity.User;

/**
 * Created by Slava on 21.04.2015.
 */
public interface UserService {
    User find(long id);
}
