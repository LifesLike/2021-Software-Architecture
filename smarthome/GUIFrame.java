package FinalProject.smarthome;

import javax.swing.*;
import java.awt.*;

public class GUIFrame extends JFrame {
    Container frame = this.getContentPane(); // 메인 컨테이너 객체
    Color color = new Color(204, 255, 153, 200);
    ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
    Image img = imgicon.getImage();
    Home H = new Home(this);
    GarageDoor GD = new GarageDoor(this);
    AddService AS = new AddService(this);


    public GUIFrame(String title) {
        super(title);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(H);
        this.setVisible(true);
    }

    public void change(String str) {
        if (str.equals("garagedoor")) {
            frame.removeAll();
            frame.add(GD);
            revalidate();
            repaint();
        } else if (str.equals("home")) {
            frame.removeAll();
            frame.add(H);
            revalidate();
            repaint();
        } else if (str.equals("addservice")) {
            frame.removeAll();
            frame.add(AS);
            revalidate();
            repaint();
        }


    }
}

