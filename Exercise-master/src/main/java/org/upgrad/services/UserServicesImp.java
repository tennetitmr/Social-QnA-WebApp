package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.repository.UserRepository;

import java.util.Date;

@Service
public class UserServicesImp implements UserService {

    private final UserRepository userRepository;

    public UserServicesImp(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public void addUserDetails(String userName, String email, String password, String role) {
        userRepository.addUserDetails(userName,email,password,role);
    }

    @Override
    public void addUserProfileDetails(int user_id, String firstName, String lastName, String aboutMe,
                                      Date dob, String contactNumber, String country) {
        userRepository.addUserProfileDetails(user_id, firstName, lastName, aboutMe, dob, contactNumber, country);
    }

    @Override
    public int findUserId() {
        int id = userRepository.findLastAddedUserId();
        return id;
    }

    @Override
    public String findUserByUsername(String userName) {
        String uName = userRepository.findUserByName(userName);
        return uName;
    }

    @Override
    public String findUserByEmail(String email) {
        String mailId = userRepository.findUserByEmailId(email);
        return mailId;
    }

}
