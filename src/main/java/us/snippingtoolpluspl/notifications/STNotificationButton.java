package us.snippingtoolpluspl.notifications;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Shane This will be a custom button class so that it can be manipulated and themed easily and added to our notification windows.
 */
public class STNotificationButton extends JComponent implements MouseListener
{
    public final int ACTIVE = 0;
    public final int CLOSE = 1;
    
    private int type;
    private String text;
    
    private String texturePath = STTheme.getThemeRootPath();
    
    private Image hover; 
    private Image normal;
    private Image pressed;
    private Image current;
    
    private JPanel titlePanel;
    private JLabel title;
    
    public STNotificationButton(int type, String text)
    {
        this.type = type;
        this.text = text;
        
        switch(type)
        {
        case ACTIVE:
            texturePath += "button/";
            this.setSize(STTheme.getThemeButtonWidth(), STTheme.getThemeButtonHeight());
            break;
        case CLOSE:
            this.setSize(STTheme.getThemeCloseWidth(), STTheme.getThemeCloseHeight());
            texturePath += "close/";
            break;
        }
        hover = Toolkit.getDefaultToolkit().getImage(texturePath+"hover.png");
        normal = Toolkit.getDefaultToolkit().getImage(texturePath+"normal.png");
        pressed = Toolkit.getDefaultToolkit().getImage(texturePath+"pressed.png");
        
        current = normal;
        
        enableInputMethods(true);
        addMouseListener(this);
        
        titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(0,0,0,0));
        title = new JLabel(text);
        
        titlePanel.add(title, BorderLayout.CENTER);
        this.add(titlePanel);
        this.setVisible(true);
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(current, 0, 0, this);
        repaint();
        g.dispose();
    }
    @Override
    public void mouseClicked(MouseEvent arg0)
    {
        
    }
    @Override
    public void mouseEntered(MouseEvent arg0)
    {
        System.out.println("hovering...");
        current = hover;
    }
    @Override
    public void mouseExited(MouseEvent arg0)
    {
        current = normal;
    }
    @Override
    public void mousePressed(MouseEvent arg0)
    {
        current = pressed;
    }
    @Override
    public void mouseReleased(MouseEvent arg0)
    {
        current = normal;
    }
}
