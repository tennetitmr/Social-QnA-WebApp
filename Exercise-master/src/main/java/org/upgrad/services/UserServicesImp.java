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

    // This method is to add the signup details to user table
    @Override
    public void addUserDetails(String userName, String email, String password, String role) {
        userRepository.addUserDetails(userName,email,password,role);
    }

    // This method is to find the latest userId added to use it to link it in userProfile details
    @Override
    public int findUserId() {
        int id = userRepository.findLastAddedUserId();
        return id;
    }

    // This method finds if username exists in user table or not and retrieves it if exists
    @Override
    public String findUserByUsername(String userName) {
        return userRepository.findUserByName(userName);
    }

    // This method finds if email exists in user table or not and retrieves it if exists
    @Override
    public String findUserByEmail(String email) {
        String mailId = userRepository.findUserByEmailId(email);
        return mailId;
    }

    // This method is to retrieve the password from the user table
    @Override
    public String findUserPassword(String userName) {
        return userRepository.findUserPasswordByName(userName);
    }

    // This method is to get the user role
    @Override
    public String findUserRole(String userName) {
        return userRepository.findUserRoleByName(userName);
    }

    // This method is to find the username with id as reference
    @Override
    public String findUserById(int id) {
        return userRepository.findUserById(id);
    }

    // This method is to delete the user details from user table with id as reference
    @Override
    public void deleteUserDetailsById(int userId) {
        userRepository.deleteUserDetails(userId);
    }

    // This method is to get the user id with reference as username
    @Override
    public int findUserIdByName(String userName) {
        return userRepository.findUserIdByUname(userName);
    }

}
