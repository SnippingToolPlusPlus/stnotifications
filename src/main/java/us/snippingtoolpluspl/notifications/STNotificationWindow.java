package us.snippingtoolpluspl.notifications;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Shane This is the notifications windows, what you see.
 */
public class STNotificationWindow extends JComponent
{
    private String texturePath = STTheme.getThemeRootPath() + "/window/";
    private String typePath = STTheme.getThemeRootPath() + "/type/";

    private Image texture;
    private Image type;

    private ImageIcon icon;
    
    public STNotificationWindow(STNotificationType t, boolean buttons)
    {
        if (buttons == false)
            texturePath += "basic.png";
        else
        {
            texturePath += "interactive.png";
        }

        switch (t)
        {
        case INFO:
            typePath += "normal.png";
            break;
        case ERROR:
            typePath += "error.png";
            break;
        case WARNING:
            typePath += "warning.png";
            break;
        case MESSAGE:
            typePath += "normal.png";
            break;
        case SUCCESS:
            typePath += "success.png";
            break;
        }
        texture = Toolkit.getDefaultToolkit().getImage(texturePath);
        type = Toolkit.getDefaultToolkit().getImage(typePath);
        
        this.setSize(STTheme.getThemeWidth(), STTheme.getThemeHeight());
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(texture, 0, 0, this);
        g2d.drawImage(type, 0, 0, this);
        g2d.dispose();
    }
}
