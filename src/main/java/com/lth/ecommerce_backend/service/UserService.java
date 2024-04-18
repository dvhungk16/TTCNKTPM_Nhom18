package com.lth.ecommerce_backend.service;

import com.lth.ecommerce_backend.exception.UserException;
import com.lth.ecommerce_backend.model.User;

public interface UserService {
    public User findUserById(Long userId) throws UserException;
    public User findUserByJwt(String jwt) throws UserException;
}
