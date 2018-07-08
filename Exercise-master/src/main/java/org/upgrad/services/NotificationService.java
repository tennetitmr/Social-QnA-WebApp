package org.upgrad.services;

import org.upgrad.models.Notification;

import java.util.List;

public interface NotificationService {
    /**
     * It should be a GET request and will not require any parameter from the user.
     * If the user is not logged in and tries to access the endpoint, return the JSON response "Please Login first to
     * access this endpoint!" with the corresponding HTTP status.
     * If the user is logged in and tries to access the endpoint, return the JSON response of all the notifications of
     * that user with corresponding HTTP status.  Also, make sure to mark as read all the new notifications, if any.
     */
    Iterable<Notification> getAllNotifications(Integer userId);
}
