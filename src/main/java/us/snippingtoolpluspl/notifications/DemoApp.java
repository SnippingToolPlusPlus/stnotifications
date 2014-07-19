package us.snippingtoolpluspl.notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class DemoApp
{
    STNotificationButton[] buttons = new STNotificationButton[3];
    public DemoApp()
    {   
        for(int i = 0; i < 3; i++)
        {
            buttons[i] = new STNotificationButton(0, "Button "+i);
            buttons[i].addActionListener(new ActionListener()
            {
                
                @Override
                public void actionPerformed(ActionEvent arg0)
                {
                    System.out.println("Clicked");
                }
            });
        }
        new STNotification("Uploading...", "This is a sample message that could really be anything", buttons, STNotificationType.SUCCESS);
    }

    public static void main(String[] args)
    {
        new DemoApp();
    }
}
