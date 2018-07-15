package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.UserProfile;
import org.upgrad.repository.UserProfileRepository;
import org.upgrad.repository.UserRepository;

import java.util.Date;

@Service
public class UserServicesImp implements UserService {

    private final UserRepository userRepository;

    public UserServicesImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUserDetails(String userName, String email, String password, String role) {
        userRepository.addUserDetails(userName,email,password,role);
    }

    @Override
    public int findUserId() {
        int id = userRepository.findLastAddedUserId();
        return id;
    }

    @Override
    public String findUserByUsername(String userName) {
        return userRepository.findUserByName(userName);
    }

    @Override
    public String findUserByEmail(String email) {
        String mailId = userRepository.findUserByEmailId(email);
        return mailId;
    }

    @Override
    public String findUserPassword(String userName) {
        return userRepository.findUserPasswordByName(userName);
    }

    @Override
    public String findUserRole(String userName) {
        return userRepository.findUserRoleByName(userName);
    }

    @Override
    public String findUserById(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void deleteUserDetailsById(int userId) {
        userRepository.deleteUserDetails(userId);
    }

    @Override
    public int findUserIdByName(String userName) {
        return userRepository.findUserIdByUname(userName);
    }

}
