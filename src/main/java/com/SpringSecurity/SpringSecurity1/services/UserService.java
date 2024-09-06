package com.SpringSecurity.SpringSecurity1.services;

import com.SpringSecurity.SpringSecurity1.dto.LoginDto;
import com.SpringSecurity.SpringSecurity1.dto.SignUpDto;
import com.SpringSecurity.SpringSecurity1.dto.UserDto;
import com.SpringSecurity.SpringSecurity1.entities.User;
import com.SpringSecurity.SpringSecurity1.exceptions.ResourceNotFoundException;
import com.SpringSecurity.SpringSecurity1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()->new ResourceNotFoundException("User with email"+username+"not found"));
    }

    public UserDto signUp(SignUpDto signUpDto) {
      Optional<User> user= userRepository.findByEmail(signUpDto.getEmail());
      if(user.isPresent()){
          throw new BadCredentialsException("User with this email alredy exist");
      }

      User tobeCreatedUser=modelMapper.map(signUpDto,User.class);
      tobeCreatedUser.setPassword(passwordEncoder.encode(tobeCreatedUser.getPassword()));

      User saveUser=userRepository.save(tobeCreatedUser);
      return modelMapper.map(saveUser,UserDto.class);

    }


}
