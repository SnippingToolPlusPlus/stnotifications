package us.snippingtoolpluspl.notifications;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class STNotification extends JFrame
{
    static STNotificationButton[] b = new STNotificationButton[3];
    
    private GridLayout buttonLayout;
    private JPanel windowPanel;
    private JPanel compPanel;
    
    private STNotificationWindow window;
    
    private int buttonMarginLeft = STTheme.getButtonMarginLeft();
    private int buttonMargin = STTheme.getButtonMargin();
    private int buttonHeight = STTheme.getButtonWindowHeight();
    
    private JTextArea messageBox;
    private JLabel titleLabel;
    
    public STNotification(String title, String message, STNotificationButton[] buttons, STNotificationType type)
    {
        this.setType(Type.UTILITY);
        windowPanel = new JPanel(new BorderLayout());
        compPanel = new JPanel(null);
        
        if(buttons != null)
        {
            window = new STNotificationWindow(type, true);
            windowPanel.add(window);         
            
            
            int x = buttonMarginLeft;
            for(int i = 0; i < buttons.length; i++)
            {
                buttons[i].setLocation(x, buttonHeight);
                x += buttonMargin + STTheme.getThemeButtonWidth();
                compPanel.add(buttons[i]);
            }
        }
//        titleLabel = new JLabel(title);
//        titleLabel.setForeground(Color.black);
//        titleLabel.setBounds(100, 20, 50,50);
//        compPanel.add(titleLabel);
        
        compPanel.setBackground(new Color(0,0,0,0));
        windowPanel.add(compPanel, BorderLayout.CENTER);
        this.add(windowPanel);
        this.setSize(STTheme.getThemeWidth(), STTheme.getThemeHeight());
        this.setLocation(STTheme.getScreenLocationX(this), STTheme.getScreenLocationY(this));
        this.setUndecorated(true);
        this.setVisible(true);
    }
}
