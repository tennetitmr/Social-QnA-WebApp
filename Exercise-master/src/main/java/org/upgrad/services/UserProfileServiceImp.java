package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.UserProfile;
import org.upgrad.repository.UserProfileRepository;
import org.upgrad.repository.UserRepository;

import java.util.Date;

@Service
public class UserProfileServiceImp implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImp(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    // This method adds the user details into DB
    @Override
    public void addUserProfileDetails(int user_id, String firstName, String lastName, String aboutMe,
                                      Date dob, String contactNumber, String country) {
        userProfileRepository.addUserProfileDetails(user_id, firstName, lastName, aboutMe, dob, contactNumber, country);
    }

    // This method retrieves the user profiles details based on user id provided
    @Override
    public Iterable<UserProfile> getUserProfile(int id) {
        return userProfileRepository.getUserProfileByUId(id);
    }

    // This method finds the first name of the user to check if the user id exists in user profile
    @Override
    public String findUserProfileById(int id) {
        return userProfileRepository.findUserById(id);
    }

    // This method deletes the user details from userProfile table with userId as reference
    @Override
    public void deleteUserProfileDetailsById(int id) {
        userProfileRepository.deleteUserProfileById(id);
    }

}
