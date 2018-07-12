package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.Notification;

import java.util.List;

@Service
public class NotificationServiceImp implements NotificationService {
    @Override
    public List <Notification> getAllNotifications(Integer user_id) {
        return null;
    }
}
