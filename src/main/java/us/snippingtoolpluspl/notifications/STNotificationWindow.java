package us.snippingtoolpluspl.notifications;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * 
 * @author Shane This is the notifications windows, what you see.
 */
public class STNotificationWindow extends JComponent
{
    private String texturePath = STTheme.getRootPath() + "/window/";
    private String typePath = STTheme.getRootPath() + "/type/";
    private String titlePath = STTheme.getRootPath() + "/titles/";

    private Image texture;
    private Image type;
    private Image titleImage;

    private ImageIcon icon;

    private STNotificationTitle title;

    public STNotificationWindow(STNotificationType t, STNotificationTitle title, boolean buttons)
    {
        this.title = title;

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
        switch (title)
        {
        case NONE:
            break;
        case TITLE_0:
            titleImage = Toolkit.getDefaultToolkit().getImage(titlePath + "0.png");
            break;
        case TITLE_1:
            titleImage = Toolkit.getDefaultToolkit().getImage(titlePath + "1.png");
            break;
        case TITLE_2:
            titleImage = Toolkit.getDefaultToolkit().getImage(titlePath + "2.png");
            break;
        case TITLE_3:
            break;
        default:
            break;
        }
        texture = Toolkit.getDefaultToolkit().getImage(texturePath);
        type = Toolkit.getDefaultToolkit().getImage(typePath);

        this.setOpaque(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setSize(STTheme.getWidth(), STTheme.getHeight());
        this.setVisible(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        if (title == STNotificationTitle.NONE)
        {
            g2d.drawImage(texture, 0, 0, this);
            g2d.drawImage(type, 0, 0, this);
        }
        else
        {
            g2d.drawImage(texture, 0, 0, this);
            g2d.drawImage(type, 0, 0, this);
            g2d.drawImage(titleImage, 0, 0, this);
        }

        g2d.dispose();
        repaint();
    }
}
