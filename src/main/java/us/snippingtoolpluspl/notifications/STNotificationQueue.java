package us.snippingtoolpluspl.notifications;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Shane
 * 
 *         Will start the animation process of the first notification in the queue then remove it and proceed to the next notification in queue. This insures
 *         that all notifications are displayed fairly and user has time to see each one before they leave.
 */
public class STNotificationQueue implements Runnable
{
    private Queue<STNotification> queue;
    private int pauseTime;
    private int travelDistance;
    private int rate;

    private boolean running = false;

    private STNotification next;

    private Thread thread;

    public STNotificationQueue(int pause, int travel, int rate)
    {
        queue = new LinkedList<STNotification>();
        pauseTime = pause;
        this.rate = rate;
        if (this.rate > 20)
            rate = 20;

        travelDistance = travel;

        thread = new Thread(this);
    }

    public void add(STNotification n)
    {
        queue.add(n);

        if (!running)
            thread.start();
    }

    public void run()
    {
        running = true;
        while (!queue.isEmpty())
        {
            next = queue.poll();
            next.setVisible(true);

            int start = next.getLocation().y;

            try
            {
                while (next.getLocation().y > (start - travelDistance))
                {
                    next.setLocation(next.getX(), next.getLocation().y - 1);
                    Thread.sleep(20 - rate);
                }
                Thread.sleep(pauseTime);
                while (next.getLocation().y < start)
                {
                    next.setLocation(next.getX(), next.getLocation().y + 1);
                    Thread.sleep(20 - rate);
                }
                next.dispose();
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        running = false;
    }
}
