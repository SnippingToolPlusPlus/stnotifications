package us.snippingtoolpluspl.notifications;

import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 
 * @author Shane
 * 
 *         This class will be used to pull the root theme directory from a preferences file. This will need to be changed by the user.
 * 
 *         For now it will simply point to the default theme location
 * 
 */
public class STTheme
{
    public static String getThemeRootPath()
    {
        return "src/main/resources/themes/default/";
    }

    public static int getThemeHeight()
    {
        return 110;
    }

    public static int getThemeWidth()
    {
        return 250;
    }
    public static int getThemeButtonWidth()
    {
        return 60;
    }
    public static int getThemeButtonHeight()
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
    public static int getThemeCloseWidth()
    {
        return 20;
    }
    public static int getThemeCloseHeight()
    {
        return 15;
    }
    
    public static int getScreenLocationY(JFrame w)
    {
        Insets screenMax = Toolkit.getDefaultToolkit().getScreenInsets(w.getGraphicsConfiguration());

        // Set it to the bottom right of the screen above the task tray;
        int taskbarSize = screenMax.bottom;
        int taskbarYlocation = Toolkit.getDefaultToolkit().getScreenSize().height - taskbarSize;

        return taskbarYlocation - getThemeHeight();
    }

    public static int getScreenLocationX(JFrame w)
    {
        return Toolkit.getDefaultToolkit().getScreenSize().width - getThemeWidth();
    }

}
