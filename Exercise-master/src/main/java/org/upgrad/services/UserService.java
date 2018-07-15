package org.upgrad.services;

public interface UserService {

    void addUserDetails(String userName, String email, String password, String role);

    int findUserId();

    String findUserByUsername(String userName);

    String findUserByEmail(String email);

    String findUserPassword(String userName);

    String findUserRole(String userName);
}
