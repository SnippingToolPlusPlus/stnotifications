package us.snippingtoolpluspl.notifications;

import javax.swing.JOptionPane;

public class DemoApp
{
    public DemoApp()
    {
        System.out.println("World");
        JOptionPane.showMessageDialog(null, "This was a triumph");
    }

    public static void main(String[] args)
    {
        System.out.println("Hello");
        new DemoApp();
    }
}
