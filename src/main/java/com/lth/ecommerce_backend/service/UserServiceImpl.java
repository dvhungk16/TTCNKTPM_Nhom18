package com.lth.ecommerce_backend.service;

import com.lth.ecommerce_backend.config.JwtProvider;
import com.lth.ecommerce_backend.exception.UserException;
import com.lth.ecommerce_backend.model.User;
import com.lth.ecommerce_backend.repository.UserRepository;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UserException("User not found with id: " + userId);
    }

    @Override
    public User findUserByJwt(String jwt) throws UserException {
        String email = jwtProvider.getEmailFromToken(jwt);

        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UserException("User not found with email " + email);
        }
        return user;
    }
}
