package org.upgrad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.services.NotificationService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private NotificationService notificationService;

    /**
     *
     * @param session
     * @return
     */
    @GetMapping("/notification/all")
    public ResponseEntity <?> getAllNotification(HttpSession session) {
//        if (session.getAttribute("currUser")!=null) {
//            return new ResponseEntity<>("Invalid credentials",HttpStatus.UNAUTHORIZED);
//        }
//
//        else {
            return new ResponseEntity <> ( notificationService.getAllNotifications ( 2 ), HttpStatus.OK );
//        }
    }
}
