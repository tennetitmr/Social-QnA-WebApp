package org.upgrad.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.upgrad.model.User;
import org.upgrad.model.UserProfile;

import java.util.Date;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
        @Transactional
        @Modifying
        @Query(nativeQuery = true,value="INSERT INTO users (userName,email,password,role) VALUES (?1,?2,?3,?4)")
        void addUserDetails(String userName, String email, String password, String role);

        @Query(nativeQuery = true,value="SELECT max(id) FROM users ")
        int findLastAddedUserId();

        @Query(nativeQuery = true,value=" SELECT userName from users WHERE UPPER(userName)= UPPER(?1)")
        String findUserByName(String userName);

        @Query(nativeQuery = true,value=" SELECT id from users WHERE UPPER(userName)= UPPER(?1)")
        int findUserIdByUname(String userName);

        @Query(nativeQuery = true,value=" SELECT userName from users WHERE id = ?1")
        String findUserById(int userId);

        @Query(nativeQuery = true,value = "SELECT email from users WHERE UPPER(email) = UPPER(?1)")
        String findUserByEmailId(String email);

        @Query(nativeQuery = true,value = "SELECT password from users WHERE UPPER(userName) = UPPER(?1)")
        String findUserPasswordByName(String userName);

        @Query(nativeQuery = true,value = "SELECT role from users WHERE UPPER(userName) = UPPER(?1)")
        String findUserRoleByName(String userName);


        @Transactional
        @Modifying
        @Query(nativeQuery = true,value="DELETE FROM users WHERE id = ?1")
        void deleteUserDetails(int userId);

}
