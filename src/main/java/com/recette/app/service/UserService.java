package com.recette.app.service;


import com.recette.app.dto.AuthResponse;
import com.recette.app.dto.AuthRequest;
import com.recette.app.entity.User;
import com.recette.app.exception.errors.CustomException;
import com.recette.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class UserService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).get();
    }

//    public AuthResponse register(AuthRequest request) {
//
//        Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());
//
//        if(optionalUser.isPresent()){
//            throw new CustomException("Username already exists");
//        }
//
//        User user = User.builder()
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .build();
//
//        userRepository.save(user);
//
//        return new AuthResponse(user.getUsername());
//    }
//
//
//    public AuthResponse authenticate(AuthRequest request) {
//
//        var user = userRepository.findByUsername(request.getUsername())
//                .orElseThrow(() -> new CustomException("Unknown User"));
//
//    }
}
