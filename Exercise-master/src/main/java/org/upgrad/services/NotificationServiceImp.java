package org.upgrad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.models.Notification;
import org.upgrad.repositories.UserRepository;

import java.util.List;
@Service
public class NotificationServiceImp implements NotificationService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<Notification> getAllNotifications(Integer userId) {
        return userRepository.getAllUserNotification ( userId );
    }
}
