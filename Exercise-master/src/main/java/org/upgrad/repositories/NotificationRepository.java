package org.upgrad.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.upgrad.models.Notification;

public interface NotificationRepository  extends CrudRepository<Notification, Integer> {
    /**
     * read all the new notifications of logged in user
     *
     * @param userId logged in user id
     * @return list of all notification of user
     */
    @Query(nativeQuery = true, value = "SELECT * FROM Notification where user_id = ?1")
    Iterable <Notification> getAllUserNotification(Integer user_id);
}
