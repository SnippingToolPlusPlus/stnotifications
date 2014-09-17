package us.snippingtoolpluspl.notifications;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DemoApp
{
    STNotificationQueue queue;
    STNotification notification, clickNotification;

    public DemoApp()
    {
        /* Sets the theme to be used */
        STTheme.setThemePath("src/main/resources/themes/cloudy/");

        /* create the notification queue and set the pause and speed */
        queue = new STNotificationQueue(3000, 17);

        /* create a new notification object */
        notification = new STNotification("upload-failed", STNotificationType.ERROR);

        /* add the notification to the queue, it will then be queued for display */
        queue.add(notification);

        /* if you need to add more notifications, it's as simple as.. */
        notification = new STNotification("upload-done", STNotificationType.SUCCESS);
        queue.add(notification);

        /* And then the notification will be displayed as soon as every notification before
         * it has finished displaying.
         */

        /* You can also add on click events to them! When clicked, this next notification
         * will show a JOptionPane. 
         */
        clickNotification = new STNotification("saved", STNotificationType.WARNING);
        clickNotification.addMouseListener(new MouseListener()
        {
            public void mouseReleased(MouseEvent e)
            {
            }

            public void mousePressed(MouseEvent e)
            {
            }

            public void mouseExited(MouseEvent e)
            {
            }

            public void mouseEntered(MouseEvent e)
            {
            }

            public void mouseClicked(MouseEvent e)
            {
                clickNotification.dispose();
            }
        });

        queue.add(clickNotification);
        
        notification = new STNotification("upload-done", STNotificationType.SUCCESS);
        queue.add(notification);
    }

    public static void main(String[] args)
    {
        new DemoApp();
    }
}
