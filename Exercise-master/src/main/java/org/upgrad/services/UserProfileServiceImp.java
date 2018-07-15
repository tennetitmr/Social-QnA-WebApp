package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.UserProfile;
import org.upgrad.repository.UserProfileRepository;

import java.util.Date;

@Service
public class UserProfileServiceImp implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImp(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void addUserProfileDetails(int user_id, String firstName, String lastName, String aboutMe, Date dob, String contactNumber, String country) {
        userProfileRepository.addUserProfileDetails ( user_id, firstName, lastName, aboutMe, dob, contactNumber, country );
    }

    @Override
    public Iterable <UserProfile> getUserProfile(int id) {
        return userProfileRepository.getUserProfileByUId ( id );
    }

    @Override
    public String findUserProfileById(int id) {
        return userProfileRepository.findUserById ( id );
    }

}
