package us.snippingtoolpluspl.notifications;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
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
    	int height = Toolkit.getDefaultToolkit().getImage(getRootPath()+"/window/window.png").getHeight(null);
    	return height;
    }
    public static int getWidth()
    {
    	int width = Toolkit.getDefaultToolkit().getImage(getRootPath() + "/window/window.png").getWidth(null);
    	return width;
    }
    public static int getScreenLocationY(JFrame w)
    {
//        Insets screenMax = Toolkit.getDefaultToolkit().getScreenInsets(w.getGraphicsConfiguration());
//
//        // Set it to the bottom right of the screen below the task tray;
//        int taskbarSize = screenMax.bottom;
//        int taskbarYlocation = Toolkit.getDefaultToolkit().getScreenSize().height - taskbarSize;

 //       return taskbarYlocation - getHeight();
        
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        return screenHeight;
    }

    public static int getScreenLocationX(JFrame w)
    {
        return Toolkit.getDefaultToolkit().getScreenSize().width - getWidth();
    }
    public static int getTaskbarHeight()
    {
        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle taskSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        
        int taskHeight = scrnSize.height - taskSize.height;
        return taskHeight;
    }
    public static int getTravelDistance()
    {
    	return getTaskbarHeight() + getHeight();
    }
    public static int getTravelLocation()
    {
    	int scrnHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
    	return scrnHeight - getTravelDistance();
    }

}
