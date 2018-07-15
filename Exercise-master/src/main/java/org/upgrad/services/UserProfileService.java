package org.upgrad.services;

import org.upgrad.model.UserProfile;

import java.util.Date;

public interface UserProfileService {
    void addUserProfileDetails(int user_id, String firstName, String lastName, String aboutMe, Date dob, String contactNumber, String country);

    String findUserProfileById(int id);

    Iterable <UserProfile> getUserProfile(int id);
}
