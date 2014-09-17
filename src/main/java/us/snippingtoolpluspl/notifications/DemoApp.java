package us.snippingtoolpluspl.notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class DemoApp
{
    STNotificationQueue queue;
    STNotification notification;

    public DemoApp()
    {
        System.out.println("Waiting to add to queue...");
//        notification = new STNotification("0", STNotificationType.INFO);
//        queue.add(notification);
        //queue.add(notification);
        queue = new STNotificationQueue(1000, 17);
        
        notification = new STNotification("upload-failed", STNotificationType.ERROR);
        queue.add(notification);
        notification = new STNotification("uploading",STNotificationType.INFO);
        queue.add(notification);        
        notification = new STNotification("uploading",STNotificationType.INFO);
        queue.add(notification);
        notification = new STNotification("upload-failed", STNotificationType.ERROR);
        queue.add(notification);
        notification = new STNotification("upload-done",STNotificationType.SUCCESS);
        queue.add(notification);

        System.out.println("Added all notifications to the queue!");

    }

    public static void main(String[] args)
    {
        new DemoApp();
    }
}
