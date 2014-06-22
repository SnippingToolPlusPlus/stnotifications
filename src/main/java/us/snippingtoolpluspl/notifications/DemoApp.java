package us.snippingtoolpluspl.notifications;

import javax.swing.JOptionPane;

public class DemoApp
{
    public DemoApp()
    {
        System.out.println("World");
        JOptionPane.showMessageDialog(null, "This was a triumph");
        
        /**
         * What it might look like, a STNotificationButton array would be sent in where null is
         * and then added to the window. The buttons would be created by the user and given 
         * respective listeners and what to do (Open a link, display something, etc)
         * 
         * The Type would decide what notification icon is used and any sounds the notifications
         * might play. 
         * 
         * Title and Message are obvious
         * 
         * The last thing that is done is to initialize the notification, this will finalize all 
         * properties given to it and create it. There may be other properties that can be set
         * such as: someNotification.setAnimateSpeed(); .playSound();
         */
        //STNotication someNotifications = new STNotifications("Title", "Message", null, STNotificationType.MESSAGE);
        //  someNotification.playSound();
        //	someNotification.init();
        /**
         * After the user has called init(); they can then add it to the queue system. and it will
         * then be displayed.
         */
        //STNoticationQueue notificationQueue = new STNotificationQueue();
        //	notificationQueue.add(someNotification);
    }

    public static void main(String[] args)
    {
        System.out.println("Hello");
        new DemoApp();
    }
}
