package org.upgrad.services;

import org.upgrad.model.Notification;

import java.util.List;

public interface NotificationService {

    List <Notification> getAllNotifications(Integer user_id);
}
