package us.snippingtoolpluspl.notifications;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class STNotification extends JFrame
{
    static STNotificationButton[] b = new STNotificationButton[3];
    
    private GridLayout buttonLayout;
    private JPanel panel;
    private JPanel buttonPanel;
    
    private STNotificationWindow contentPane;
    
    public STNotification(String title, String message, STNotificationButton[] buttons, STNotificationType type)
    {
        this.setType(Type.UTILITY);
        if(buttons != null)
        {
            contentPane = new STNotificationWindow(type, true);
            contentPane.setLayout(new BorderLayout());
            this.setContentPane(contentPane);
            
            this.setLocation(STTheme.getScreenLocationX(this), STTheme.getScreenLocationY(this));
            
            buttonLayout = new GridLayout(0, buttons.length);            
            panel = new JPanel(buttonLayout);
            
            for(int i = 0; i < buttons.length; i++)
                panel.add(buttons[i]);
            
            contentPane.add(panel, BorderLayout.CENTER);
        }
        
        //this.setSize(STTheme.getThemeWidth(), STTheme.getThemeHeight());
        this.setSize(getContentPane().getSize());
        this.setUndecorated(true);
        this.setVisible(true);
    }
}
