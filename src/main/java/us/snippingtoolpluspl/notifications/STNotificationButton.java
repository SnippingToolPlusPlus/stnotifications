package us.snippingtoolpluspl.notifications;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author Shane This will be a custom button class so that it can be manipulated and themed easily and added to our notification windows.
 */
public class STNotificationButton extends JButton
{
    public final int ACTIVE = 0;
    public final int CLOSE = 1;

    private int type;
    private String text;

    private String texturePath = STTheme.getRootPath();

    private ImageIcon hover;
    private ImageIcon normal;
    private ImageIcon pressed;

    public STNotificationButton(int type, String text)
    {
        this.type = type;
        this.text = text;

        switch (type)
        {
        //        case ACTIVE:
        //            texturePath += "button/";
        //            this.setSize(STTheme.getButtonWidth(), STTheme.getButtonHeight());
        //            break;
        //        case CLOSE:
        //            this.setSize(STTheme.getCloseWidth(), STTheme.getCloseHeight());
        //            texturePath += "close/";
        //            break;
        }
        hover = new ImageIcon(Toolkit.getDefaultToolkit().getImage(texturePath + "hover.png"));
        normal = new ImageIcon(Toolkit.getDefaultToolkit().getImage(texturePath + "normal.png"));
        pressed = new ImageIcon(Toolkit.getDefaultToolkit().getImage(texturePath + "pressed.png"));

        setRolloverIcon(hover);
        setIcon(normal);
        setPressedIcon(pressed);
        setRolloverEnabled(true);

        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusable(false);

        enableInputMethods(true);

        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setMargin(new Insets(0, 0, 0, 0));
        setText(text);

        setVisible(true);
        repaint();
    }

    public void paintComponents(Graphics g)
    {
        super.paintComponent(g);
        repaint();
    }
}
