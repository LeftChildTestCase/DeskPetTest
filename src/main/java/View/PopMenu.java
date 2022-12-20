package View;

import PetEntity.Urotsuki;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PopMenu {
    Urotsuki urotsuki = new Urotsuki();
    public void setPopUpMenu(JFrame jFrame, String name) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            PopupMenu popMenu = new PopupMenu();

            MenuItem itemOpen = new MenuItem("Show");
            itemOpen.addActionListener(e -> jFrame.setVisible(true));
            popMenu.add(itemOpen);

            MenuItem itemHide = new MenuItem("Hide");
            itemHide.addActionListener(e -> jFrame.setVisible(false));
            popMenu.add(itemHide);

            MenuItem Sit = new MenuItem("Sit");
            Sit.setShortcut(new MenuShortcut(1,false));
            Sit.addActionListener(e -> this.urotsuki.setStateSit());
            popMenu.add(Sit);

            MenuItem Walk = new MenuItem("Walk");
            Walk.setShortcut(new MenuShortcut(2,false));
            Walk.addActionListener(e ->  this.urotsuki.setStateWalk());
            popMenu.add(Walk);

            MenuItem Motor = new MenuItem("Motor");
            Motor.setShortcut(new MenuShortcut(3,false));
            Motor.addActionListener(e ->  this.urotsuki.setStateMotor());
            popMenu.add(Motor);


            MenuItem itemExit = new MenuItem("exit");
            itemExit.addActionListener(e -> System.exit(0));
            popMenu.add(itemExit);

            URL img_icon = ViewWindow.class.getResource("/img/icon/icon.png");
            assert img_icon != null;
            ImageIcon icon = new ImageIcon(img_icon);
            Image image = icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT);
            TrayIcon trayIcon = new TrayIcon(image,name,popMenu);
            trayIcon.setImageAutoSize(true);

            try {
                tray.add(trayIcon);
            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }
    }

}
