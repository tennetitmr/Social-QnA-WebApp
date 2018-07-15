package org.upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.model.User;
import org.upgrad.services.UserProfileService;
import org.upgrad.services.UserService;

import javax.servlet.http.HttpSession;


@RestController
public class AdminController {

    /*
     * This UserService consist of all the implementations of business logic related to user login information of the app and
     * interact with repositories to access/store data in the database.
     */
    @Autowired
    private UserService userService;

    /*
     * This UserProfileService consist of all the implementations of business logic related to user information other than login
     * of the app and interact with repositories to access/store data in the database.
     */

    @Autowired
    private UserProfileService userProfileService;

    /*
    * This end point is implemented to to delete the user details from the app
    *  user details can be deleted by 'admin' only
    *  Currently we are trying to delete user details and userprofile details.
     */

    @DeleteMapping("/api/admin/user/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable("userId") String userId, HttpSession session) {
        if (session.getAttribute("currUser") == null) {
            return new ResponseEntity<>("Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED);
        }
        else {
            int id = Integer.parseInt(userId);
            User user  = (User)session.getAttribute("currUser");
            if(String.valueOf(userService.findUserRole(user.getUserName())).equalsIgnoreCase("admin") || user.getRole().equalsIgnoreCase("admin")) {
                String uname = String.valueOf(userService.findUserById(id));
                if (!uname.equalsIgnoreCase("null")) {
                    userService.deleteUserDetailsById(id);
                    userProfileService.deleteUserProfileDetailsById(id);
                    return new ResponseEntity<>("User with userId "+id+" deleted successfully!",HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>("User with userId "+id+" doesn't exists!",HttpStatus.NO_CONTENT);
                }
            }
            else {
                return new ResponseEntity<>("You do not have rights to delete a user!", HttpStatus.UNAUTHORIZED);
            }
        }
    }

}
