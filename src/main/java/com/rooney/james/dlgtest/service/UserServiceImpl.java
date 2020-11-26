package com.rooney.james.dlgtest.service;

import com.rooney.james.dlgtest.controller.mapper.UserMapper;
import com.rooney.james.dlgtest.domain.User;
import com.rooney.james.dlgtest.domain.UserDTO;
import com.rooney.james.dlgtest.exception.UserNotFoundException;
import com.rooney.james.dlgtest.exception.UserWithMatchingEmailException;
import com.rooney.james.dlgtest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(UserDTO newUser) {
        User existingUser = userRepository.findByEmail(newUser.getEmail());

        if (existingUser != null) {
            throw new UserWithMatchingEmailException(existingUser.getEmail());
        }

        User user = userMapper.userDtoToUser(newUser);

        user.setCreatedDate(new Date());

        User savedUser = userRepository.save(user);

        log.info("Saved new user with userId: {}", savedUser.getId());
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
    public void updateUser(UserDTO updatedUserDto) throws UserNotFoundException {
        User existingUser = userRepository.findByEmail(updatedUserDto.getEmail());

        if (existingUser == null) {
            throw new UserNotFoundException(updatedUserDto.getEmail());
        }

        User updatedUser = userMapper.userDtoToUser(updatedUserDto);

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setDepartment(updatedUser.getDepartment());
        existingUser.setJobTitle(updatedUser.getJobTitle());
        existingUser.setLastModifiedDate(new Date());

        userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUserByEmail(email);
    }
}
