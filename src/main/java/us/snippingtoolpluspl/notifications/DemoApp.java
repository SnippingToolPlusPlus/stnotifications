package us.snippingtoolpluspl.notifications;

public class DemoApp
{
    STNotificationQueue queue;
    STNotification notification;

    public DemoApp()
    {
    	/* Sets the theme to be used */
    	STTheme.setThemePath("src/main/resources/themes/cloudy/");
    	
    	/* create the notification queue and set the pause and speed */
        queue = new STNotificationQueue(1000, 17);
        
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

    }

    public static void main(String[] args)
    {
        new DemoApp();
    }
}
