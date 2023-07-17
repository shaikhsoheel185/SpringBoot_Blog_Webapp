package com.blog.service.impl;

import com.blog.dto.RegistrationDto;
import com.blog.entity.Role;
import com.blog.entity.User;
import com.blog.repositry.RoleRepository;
import com.blog.repositry.UserRepository;
import com.blog.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user=new User();
        user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

   /* @Override
    public User findbyEmail(String email) {
       return userRepository.findByEmail(email);
    }*/
}
