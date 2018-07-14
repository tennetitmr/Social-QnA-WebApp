package org.upgrad.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upgrad.model.User;
import org.upgrad.services.NotificationService;
import org.upgrad.services.UserProfileService;
import org.upgrad.services.UserService;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/api/user/signup")
    public ResponseEntity <?> postUserSignup(@RequestParam("firstName") String firstName, String lastName, @RequestParam("userName") String userName, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("country") String country, String aboutMe, @RequestParam("dob") String dateOfbirth, String contactNumber) {
        String userNameResult = String.valueOf ( userService.findUserByUsername ( userName ) );
        String emailResult = String.valueOf ( userService.findUserByEmail ( email ) );
        if (!userNameResult.equals ( userName ) && !emailResult.equals ( email )) {

            String sha256hex = Hashing.sha256 ().hashString ( password, Charsets.US_ASCII ).toString ();

            Date dob = null;
            try {
                dob = new SimpleDateFormat ( "yyyy-MM-dd" ).parse ( dateOfbirth );
            } catch (ParseException e) {
                e.printStackTrace ();
            }
            userService.addUserDetails ( userName, email, sha256hex, "user" );
            int id = userService.findUserId ();
            userProfileService.addUserProfileDetails ( id, firstName, lastName, aboutMe, dob, contactNumber, country );
            return new ResponseEntity <> ( userName + " successfully registered", HttpStatus.OK );
        } else if (userNameResult.equals ( userName )) {
            return new ResponseEntity <> ( "Try any other Username, this Username has already been taken.", HttpStatus.FORBIDDEN );
        } else if (emailResult.equals ( email )) {
            return new ResponseEntity <> ( "This user has already been registered, try with any other emailId.", HttpStatus.FORBIDDEN );
        } else {
            return new ResponseEntity <> ( "", HttpStatus.NOT_ACCEPTABLE );
        }
    }

    @PostMapping("/api/user/login")
    public ResponseEntity <?> postUserSignin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session) {

        String passwordByUser = String.valueOf ( userService.findUserPassword ( userName ) );
        String sha256hex = Hashing.sha256 ().hashString ( password, Charsets.US_ASCII ).toString ();
        if (!(passwordByUser.equalsIgnoreCase ( sha256hex ))) {
            return new ResponseEntity <> ( "Invalid Credentials", HttpStatus.UNAUTHORIZED );
        } else if (String.valueOf ( userService.findUserRole ( userName ) ).equalsIgnoreCase ( "admin" )) {
            User user = new User ( userName );
            session.setAttribute ( "currUser", user );
            return new ResponseEntity <> ( "You have logged in as admin!", HttpStatus.OK );
        } else {
            User user = new User ( userName );
            session.setAttribute ( "currUser", user );
            return new ResponseEntity <> ( "You have logged in successfully!", HttpStatus.OK );
        }
    }

    @PostMapping("/api/user/logout")
    public ResponseEntity <String> postUserSignout(HttpSession session) {
        if (session.getAttribute ( "currUser" ) == null)
            return new ResponseEntity <> ( "You are currently not logged in", HttpStatus.UNAUTHORIZED );
        else {
            session.removeAttribute ( "currUser" );
            return new ResponseEntity <> ( "You have logged out successfully!", HttpStatus.OK );
        }
    }

    @GetMapping("/api/user/userprofile/{userId}")
    public ResponseEntity <?> getUserProfile(@PathVariable("userId") int id, HttpSession session) {

        if (session.getAttribute ( "currUser" ) == null) {
            return new ResponseEntity <> ( "Please Login first to access this endpoint", HttpStatus.UNAUTHORIZED );
        } else {

            if (!String.valueOf ( userProfileService.findUserProfileById ( id ) ).equalsIgnoreCase ( "null" )) {
                return new ResponseEntity <> ( userProfileService.getUserProfile ( id ), HttpStatus.OK );
            } else {
                return new ResponseEntity <> ( "User Profile not found!", HttpStatus.NOT_FOUND );
            }
        }

    }

    @GetMapping("/api/user/notification/all")
    public ResponseEntity <?> getAllNotifications(HttpSession session) {

        User currUser = (User) session.getAttribute ( "currUser" );

        if (currUser == null) {

            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );

        } else {

            return new ResponseEntity <> ( notificationService.getAllNotifications ( currUser.getId () ), HttpStatus.OK );
        }
    }
}
