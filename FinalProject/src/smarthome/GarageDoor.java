package smarthome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GarageDoor extends JPanel {
    Color color = new Color(204, 255, 153, 200);
    ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
    Image img = imgicon.getImage();
    private GUIFrame GF;

    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.drawImage(img, 80, 100, 130, 120, null);

    }

    public GarageDoor(GUIFrame GF) {
        this.GF = GF;
        setSize(300, 300);
        JButton open = new JButton("Door Open");
        JButton close = new JButton("Door Close");
        JButton stop = new JButton("Door Stop");
        JButton detectobstacle = new JButton("Detect Obstacle");
        JButton home = new JButton("Home");
        setLayout(new FlowLayout());
        setBackground(color);

        add(open);
        add(close);
        add(stop);
        add(detectobstacle);
        add(home);

        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("문이 열립니다.");
            }
        });
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("문이 닫힙니다.");
            }
        });
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("문이 멈췄습니다.");
            }
        });
        detectobstacle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GF.change("detectobstacle");

            }
        });
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                GF.change("home");

            }
        });

    }


}

