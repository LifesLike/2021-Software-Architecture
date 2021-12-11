package FinalProject.smarthome;

import FinalProject.garageDoor.sensor.ObstacleSensorDriver;
import FinalProject.smarthome.communication.Communication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GarageDoor extends JPanel {
    private Communication communication;
    Color color = new Color(204, 255, 153, 200);
    ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
    Image img = imgicon.getImage();
    private GUIFrame GF;

    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.drawImage(img, 80, 100, 130, 120, null);

    }

    public GarageDoor(GUIFrame GF, Communication communication) {
        this.GF = GF;
        this.communication = communication;
        setSize(300, 300);
        JButton open = new JButton("Door Open");
        JButton close = new JButton("Door Close");
        JButton stop = new JButton("Door Stop");
        JButton home = new JButton("Home");
        setLayout(new FlowLayout());
        setBackground(color);

        add(open);
        add(close);
        add(stop);
        add(home);

        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                communication.open();
            }
        });
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                communication.close();
            }
        });
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                communication.stop();
            }
        });

        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                GF.change("home");

            }
        });

    }


}
