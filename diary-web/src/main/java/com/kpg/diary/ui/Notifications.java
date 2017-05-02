package com.kpg.diary.ui;

import org.springframework.stereotype.Component;

import com.vaadin.ui.Notification;

/**
 * Class is for notification
 * 
 * @author Ankit Sood Dec 9, 2016
 */
@Component("notifications")
public class Notifications {

    /**
     * 
     * For display error notification
     * 
     * @param text
     */
    public void displayErrorNotification(String text) {
	Notification.show("", text, Notification.Type.ERROR_MESSAGE);
    }

    /**
     * 
     * For display warning notification
     * 
     * @param text
     */
    public void displayWarningNotification(String text) {
	Notification.show("", text, Notification.Type.WARNING_MESSAGE);
    }

    /**
     * 
     * For display tray notification
     * 
     * @param text
     */
    public void displayTrayNotifications(String text) {
	Notification.show("", text, Notification.Type.TRAY_NOTIFICATION);
    }

}
