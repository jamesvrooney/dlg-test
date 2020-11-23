package com.rooney.james.dlgtest.service;

import com.rooney.james.dlgtest.controller.mapper.UserMapper;
import com.rooney.james.dlgtest.domain.User;
import com.rooney.james.dlgtest.domain.UserDTO;
import com.rooney.james.dlgtest.exception.UserNotFoundException;
import com.rooney.james.dlgtest.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void createUser(UserDTO newUser) {

    }

    @Override
    public UserDTO getUser(String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserNotFoundException(email);
        }

        UserDTO retrievedUser = userMapper.userToUserDto(user);

        return retrievedUser;
    }

    @Override
    public void updateUser(UserDTO updatedUser) throws UserNotFoundException {

    }

    @Override
    public void deleteUser(String email) {

    }
}
