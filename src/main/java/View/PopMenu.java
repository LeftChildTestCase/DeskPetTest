package View;

import PetEntity.Urotsuki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import static PetEntity.State.Uro_Direction.*;

public class PopMenu extends KeyAdapter {
   static Urotsuki urotsuki = new Urotsuki();
    public void setPopUpMenu(JFrame jFrame, String name) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            PopupMenu popMenu = new PopupMenu();

            MenuItem itemShow = new MenuItem("Show");
            itemShow.addActionListener(e ->  jFrame.setVisible(true));
            popMenu.add(itemShow);

            MenuItem itemHide = new MenuItem("Hide");
            itemHide.addActionListener(e ->  jFrame.setVisible(false));
            popMenu.add(itemHide);

            MenuItem Sit = new MenuItem("Sit");
            Sit.addActionListener(e -> this.urotsuki.setStateSit());
            popMenu.add(Sit);

            MenuItem Walk = new MenuItem("Walk");
            Walk.addActionListener(e ->  this.urotsuki.setStateWalk());
            popMenu.add(Walk);

            MenuItem Motor = new MenuItem("Motor");
            Motor.addActionListener(e ->  this.urotsuki.setStateMotor());
            popMenu.add(Motor);

            MenuItem Bat = new MenuItem("Bat");
            Bat.addActionListener(e ->  this.urotsuki.setStateBat());
            popMenu.add(Bat);

            MenuItem Keyboard = new MenuItem("Keyboard");
            Keyboard.addActionListener(e ->  this.urotsuki.setControlled());
            popMenu.add(Keyboard);


            MenuItem itemExit = new MenuItem("Exit");
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
    public void keyPressed(KeyEvent e) {
        urotsuki.setIsinControl(true);
        if (e.getKeyCode() == KeyEvent.VK_W) {
            urotsuki.setDirection(Urotsuki_back);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            urotsuki.setDirection(Urotsuki_front);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            urotsuki.setDirection(Urotsuki_right);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            urotsuki.setDirection(Urotsuki_left);
        }
    }
}
