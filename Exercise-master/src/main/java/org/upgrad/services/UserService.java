package org.upgrad.services;

import java.util.Date;

public interface UserService {

    void addUserDetails(String userName, String email, String password, String role);
    void addUserProfileDetails(int user_id, String firstName, String lastName, String aboutMe, Date dob, String contactNumber, String country);
    int findUserId();
    String findUserByUsername(String userName);
    String findUserByEmail(String email);
}
