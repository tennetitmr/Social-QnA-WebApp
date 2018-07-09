package org.upgrad.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.upgrad.model.Users;

import java.util.Date;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {
        @Transactional
        @Modifying
        @Query(nativeQuery = true,value="INSERT INTO users (userName,email,password,role) VALUES (?1,?2,?3,?4)")
        void addUserDetails(String userName, String email, String password, String role);

        @Transactional
        @Modifying
        @Query(nativeQuery = true,value="INSERT INTO user_profile (user_id,firstName,lastName,aboutMe,dob,contactNumber,country) VALUES (?1,?2,?3,?4,?5,?6,?7)")
        void addUserProfileDetails(int user_id, String firstName, String lastName, String aboutMe, Date dob, String contactNumber, String country);

        @Query(nativeQuery = true,value="SELECT max(id) FROM users ")
        int findLastAddedUserId();

        @Query(nativeQuery = true,value=" SELECT userName from users WHERE UPPER(userName)= UPPER(?1)")
        String findUserByName(String userName);

        @Query(nativeQuery = true,value = "SELECT email from users WHERE UPPER(email) = UPPER(?1)")
        String findUserByEmailId(String email);
}
