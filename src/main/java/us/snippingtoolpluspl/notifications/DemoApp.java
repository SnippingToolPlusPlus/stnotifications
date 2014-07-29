package us.snippingtoolpluspl.notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class DemoApp
{
    STNotificationButton[] buttons = new STNotificationButton[3];
    STNotificationQueue queue = new STNotificationQueue(1000, STTheme.getWidth(), 17);
    STNotification notification;

    public DemoApp()
    {
        for (int i = 0; i < 3; i++)
        {
            buttons[i] = new STNotificationButton(0, "Button " + i);
            buttons[i].addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent arg0)
                {
                    System.out.println("Clicked");
                }
            });
        }
        notification = new STNotification(null, null, null, STNotificationType.INFO, STNotificationTitle.TITLE_0);
        queue.add(notification);
        notification = new STNotification(null, null, null, STNotificationType.ERROR, STNotificationTitle.TITLE_2);
        queue.add(notification);
        notification = new STNotification(null, null, null, STNotificationType.INFO, STNotificationTitle.TITLE_0);
        queue.add(notification);
        notification = new STNotification(null, null, null, STNotificationType.SUCCESS, STNotificationTitle.TITLE_1);
        queue.add(notification);

        System.out.println("Added all notifications to the queue!");

    }

    public static void main(String[] args)
    {
        new DemoApp();
    }
}
