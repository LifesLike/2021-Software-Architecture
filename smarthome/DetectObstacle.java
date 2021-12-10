package FinalProject.smarthome;

import FinalProject.garageDoor.sensor.ObstacleSensorDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DetectObstacle extends JPanel {
    private ObstacleSensorDriver ObstacleSensorDriver;

    Color color = new Color(204, 255, 153, 200);
    ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
    Image img = imgicon.getImage();
    private GUIFrame GF;

    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.drawImage(img, 80, 100, 130, 120, null);

    }

    public DetectObstacle(GUIFrame GF) {
        JPanel panel1 = new JPanel();

        panel1.setBounds(0, 0, 300, 30);
        panel1.setBackground(color);
        panel1.setLayout(new FlowLayout());

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 30, 300, 30);
        panel2.setBackground(color);
        panel1.setLayout(new FlowLayout());

        setLayout(null);
        setSize(300, 300);
        //setLayout(new FlowLayout());
        setBackground(color);
        ButtonGroup g = new ButtonGroup();
        JRadioButton detected = new JRadioButton("Detected", false);
        JRadioButton cleared = new JRadioButton("Cleared", false);
        JButton back = new JButton("Back");
        JButton home = new JButton("Home");

        g.add(detected);
        g.add(cleared);

        panel1.add(detected);
        panel1.add(cleared);
        panel2.add(back);
        panel2.add(home);

        add(panel1);
        add(panel2);

        detected.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                ObstacleSensorDriver.obstacleDetected();
            }
        });
        cleared.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                ObstacleSensorDriver.obstacleCleared();
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GF.change("garagedoor");

            }
        });
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                GF.change("home");

            }
        });


    }


}
