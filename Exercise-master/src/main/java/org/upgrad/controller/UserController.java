package org.upgrad.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.services.UserService;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/signup")
    public ResponseEntity<?> PostUserSignup(@RequestParam("firstName") String firstName, String lastName, @RequestParam("userName") String userName,
                                            @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("country") String country,
                                            String aboutMe, @RequestParam("dob") String dateOfbirth, String contactNumber) {
        String userNameResult = userService.findUserByUsername(userName);
        String emailResult = userService.findUserByEmail(email);
        if (!userNameResult.equals(userName) && !emailResult.equals(email)) {

            if (lastName.isEmpty()) {
            lastName = "";
            }

            if (aboutMe.isEmpty()) {
            aboutMe = "";
            }

            if (contactNumber.isEmpty()) {
            contactNumber = "";
            }

            String sha256hex = Hashing.sha256()
                    .hashString(password, Charsets.US_ASCII)
                    .toString();

            Date dob= null;
            try {
                dob = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfbirth);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            userService.addUserDetails(userName,email,sha256hex,"user");
            int id = userService.findUserId();
            id++;
            userService.addUserProfileDetails(id,firstName,lastName,aboutMe,dob,contactNumber,country);
            return new ResponseEntity<>(userName + " successfully registered", HttpStatus.OK);
       }  else if (!userNameResult.isEmpty()){
                   return new ResponseEntity<>("Try any other Username, this Username has already been taken.",HttpStatus.FORBIDDEN);
        }
       else if (!emailResult.isEmpty()) {
            return new ResponseEntity<>("This user has already been registered, try with any other emailId.",HttpStatus.FORBIDDEN);
        }
        else {
            return new ResponseEntity<>("",HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
