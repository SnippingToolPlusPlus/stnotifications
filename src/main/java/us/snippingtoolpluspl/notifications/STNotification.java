package us.snippingtoolpluspl.notifications;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

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

    public STNotification(String title, String message, STNotificationButton[] buttons, STNotificationType type,
        STNotificationTitle imgTitle)
    {
        this.setType(Type.UTILITY);
        windowPanel = new JPanel(new BorderLayout());
        compPanel = new RepaintPanel(null);

        if (imgTitle == STNotificationTitle.NONE)
        {
            /** TITLE **/
            titleLabel = new JLabel(title);
            titleLabel.setForeground(STTheme.getTitleColor());
            titleLabel.setLocation(STTheme.getTitleLocation());
            titleLabel.setFont(new Font("sansserif", Font.PLAIN, STTheme.getTitleFontSize()));
            titleLabel.setSize(STTheme.getTitleSize());
            compPanel.add(titleLabel);

            /** MESSAGE **/
            messageBox = new JTextArea(message);
            messageBox.setForeground(STTheme.getMessageColor());
            messageBox.setBackground(new Color(0, 0, 0, 0));
            messageBox.setEditable(false);
            messageBox.setEnabled(false);
            messageBox.setLineWrap(true);
            messageBox.setWrapStyleWord(true);
            messageBox.setFont(new Font("Arial", Font.PLAIN, STTheme.getMessageFontSize()));
        }

        if (buttons != null)
        {
            if (imgTitle == STNotificationTitle.NONE)
            {
                /** MESSAGE **/
                messageBox.setLocation(STTheme.getActiveMessageLocation());
                messageBox.setSize(STTheme.getActiveMessageSize());
            }

            window = new STNotificationWindow(type, imgTitle, true);
            windowPanel.add(window);

            int x = buttonMarginLeft;
            for (int i = 0; i < buttons.length; i++)
            {
                buttons[i].setLocation(x, buttonHeight);
                x += buttonMargin + STTheme.getButtonWidth();
                compPanel.add(buttons[i]);
            }
        }
        else
        {
            if (imgTitle == STNotificationTitle.NONE)
            {
                /** MESSAGE **/
                messageBox.setLocation(STTheme.getMessageLocation());
                messageBox.setSize(STTheme.getMessageSize());
            }
            window = new STNotificationWindow(type, imgTitle, false);
            windowPanel.add(window);
        }
        if (imgTitle == STNotificationTitle.NONE)
            compPanel.add(messageBox);

        compPanel.setBackground(new Color(0, 0, 0, 0));
        windowPanel.add(compPanel, BorderLayout.CENTER);
        this.add(windowPanel);
        this.setSize(STTheme.getWidth(), STTheme.getHeight());
        this.setLocation(STTheme.getScreenLocationX(this), STTheme.getScreenLocationY(this));
        this.setUndecorated(true);
        //this.setVisible(true);
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
            repaint();
        }
    }
}
