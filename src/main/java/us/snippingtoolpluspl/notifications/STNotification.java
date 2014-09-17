package us.snippingtoolpluspl.notifications;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class STNotification extends JFrame
{
    private JPanel windowPanel;
    private JPanel compPanel;

    private STNotificationWindow window;

    public STNotification(String imgTitle, STNotificationType type)
    {
        this.setType(Type.UTILITY);
        windowPanel = new JPanel(new BorderLayout());
        compPanel = new RepaintPanel(null);

            window = new STNotificationWindow(type, imgTitle);
            compPanel.add(window);

        compPanel.setBackground(new Color(0, 0, 0, 0));
        windowPanel.add(compPanel, BorderLayout.CENTER);
        this.add(windowPanel);
        
        
        this.setSize(STTheme.getWidth(), STTheme.getHeight());
        this.setLocation(STTheme.getScreenLocationX(this), STTheme.getScreenLocationY(this));
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
    }

    public class RepaintPanel extends JPanel
    {
        public RepaintPanel(LayoutManager m)
        {
            setLayout(m);
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponents(g);
        }
    }
}
