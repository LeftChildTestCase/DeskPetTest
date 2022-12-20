package GraphicUtil;

import View.ViewWindow;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class RePaint {
    public static JLabel getPictureResource(String filepath) {
        JLabel jLabel = new JLabel();
        URL url = ViewWindow.class.getResource(filepath);
        assert url != null;
        ImageIcon icon = new ImageIcon(url);
        icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth() * 2,icon.getIconHeight() * 2,Image.SCALE_DEFAULT));
        jLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        jLabel.setIcon(icon);
        return jLabel;
    }

    public static void ImageRepaint(JFrame jFrame, JPanel jPanel, String filepath, int x, int y) {
        try {
            jPanel.removeAll();
            jPanel.add(getPictureResource(filepath));
            jFrame.setLocation(x,y);
            jFrame.repaint();
            jFrame.pack();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

