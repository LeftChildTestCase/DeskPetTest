package View;

import PetEntity.Urotsuki;

import javax.swing.*;
import java.awt.*;


public class ViewWindow{
    PopMenu menu = new PopMenu();
    public static int Resolution_Width;
    public static int Resolution_Height;
    private static void getResolution() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle resolution= graphicsEnvironment.getMaximumWindowBounds();
        Resolution_Width = resolution.width;
        Resolution_Height = resolution.height;
    }
    public void Launch() {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setUndecorated(true);
        jFrame.setBackground(new Color(0,0,0,0));
        jPanel.setBackground(new Color(0,0,0,0));

        jFrame.setType(JFrame.Type.UTILITY);
        menu.setPopUpMenu(jFrame,"Urotsuki");
        jFrame.setBounds(0,0,0,0);
        jFrame.setAlwaysOnTop(true);
        jFrame.setVisible(true);
        jFrame.add(jPanel);

        jFrame.addKeyListener(menu);

        getResolution();

        Urotsuki urotsuki = new Urotsuki();
        urotsuki.setFrame(jFrame,jPanel);
        urotsuki.ScreenEdgeCheck(Resolution_Width,Resolution_Height);

        urotsuki.Start();
    }
}
