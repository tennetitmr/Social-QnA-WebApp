package org.upgrad.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.upgrad.model.UserProfile;

import java.util.Date;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile,Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="INSERT INTO user_profile (user_id,firstName,lastName,aboutMe,dob,contactNumber,country) VALUES (?1,?2,?3,?4,?5,?6,?7)")
    void addUserProfileDetails(int user_id, String firstName, String lastName, String aboutMe, Date dob, String contactNumber, String country);

    @Query(nativeQuery = true,value=" SELECT firstName from user_profile WHERE user_id = ?1")
    String findUserById(int userId);

    @Query(nativeQuery = true,value="SELECT * from user_profile WHERE user_id = ?1")
    Iterable<UserProfile> getUserProfileByUId(int id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value=" DELETE from user_profile WHERE user_id = ?1")
    void deleteUserProfileById(int userId);
}
