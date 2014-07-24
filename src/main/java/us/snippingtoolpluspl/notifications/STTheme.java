package us.snippingtoolpluspl.notifications;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 
 * @author Shane
 * 
 *         This class will be used to pull the root  directory from a preferences file. This will need to be changed by the user.
 * 
 *         For now it will simply point to the default  location
 *         
 *         Everything is set to default values. when this class is finished, 
 *         it will pull the values from a config file located in the 
 *         directory.
 * 
 */
public class STTheme
{
    public static String getRootPath()
    {
        return "src/main/resources/themes/cloudy/";
    }

    public static int getHeight()
    {
        return 252;
    }

    public static int getWidth()
    {
        return 344;
    }
    public static int getButtonWidth()
    {
        return 60;
    }
    public static int getButtonHeight()
    {
        return 20;
    }
    public static int getButtonMarginLeft()
    {
        return 30;
    }
    public static int getButtonMargin()
    {
        return 5;
    }
    public static int getButtonWindowHeight()
    {
        return 75;
    }
    public static int getCloseWidth()
    {
        return 20;
    }
    public static int getCloseHeight()
    {
        return 15;
    }
    public static Point getTitleLocation()
    {
        return new Point(5,4);
    }
    public static Dimension getTitleSize()
    {
        return new Dimension(getWidth(), 18);
    }
    public static int getTitleFontSize()
    {
        return 18;
    }
    public static Color getTitleColor()
    {
        return Color.black;
    }
    public static Point getMessageLocation()
    {
        return new Point(22,32);
    }
    public static Point getActiveMessageLocation()
    {
        return new Point(22,32);
    }
    public static Dimension getActiveMessageSize()
    {
        return new Dimension(210,40);
    }
    public static Dimension getMessageSize()
    {
        return new Dimension(210, 40);
    }
    public static int getMessageFontSize()
    {
        return 14;
    }
    public static Color getMessageColor()
    {
        return Color.lightGray;
    }
    public static int getScreenLocationY(JFrame w)
    {
        Insets screenMax = Toolkit.getDefaultToolkit().getScreenInsets(w.getGraphicsConfiguration());

        // Set it to the bottom right of the screen above the task tray;
        int taskbarSize = screenMax.bottom;
        int taskbarYlocation = Toolkit.getDefaultToolkit().getScreenSize().height - taskbarSize;

        return taskbarYlocation - getHeight();
    }

    public static int getScreenLocationX(JFrame w)
    {
        return Toolkit.getDefaultToolkit().getScreenSize().width - getWidth();
    }

}
