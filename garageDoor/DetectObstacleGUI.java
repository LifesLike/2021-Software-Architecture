package FinalProject.garageDoor;

import FinalProject.smarthome.GUIFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DetectObstacleGUI extends JFrame {
    private FinalProject.garageDoor.sensor.ObstacleSensorDriver ObstacleSensorDriver;
    Container frame = this.getContentPane();

    public DetectObstacleGUI(String title) {
        super(title);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        this.setVisible(true);

    }

    public void init() {
        frame.add(new DetectObstacleGUI.detectobstaclePanel());
    }

    class detectobstaclePanel extends JPanel {
        Color color = new Color(204, 255, 153, 200);
        ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
        Image img = imgicon.getImage();
        private GUIFrame GF;

        public void paintComponent(Graphics g) {
            // TODO Auto-generated method stub
            super.paintComponent(g);

            g.drawImage(img, 80, 100, 130, 120, null);

        }

        detectobstaclePanel() {
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

            g.add(detected);
            g.add(cleared);

            panel1.add(new JLabel("Obstacle Detection Controller"));

            panel2.add(detected);
            panel2.add(cleared);

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


        }
    }
}
