package FinalProject.smarthome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel {
    Color color = new Color(204, 255, 153, 200);
    ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
    Image img = imgicon.getImage();
    private GUIFrame GF;

    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.drawImage(img, 80, 100, 130, 120, null);

    }

    public Home(GUIFrame GF) {
        this.GF = GF;
        JButton garageDoor = new JButton("GarageDoor");
        JButton addService = new JButton("AddService");
        JButton home = new JButton("Home");
        setLayout(new FlowLayout());
        setBackground(color);
        add(garageDoor);
        add(addService);
        garageDoor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                GF.change("garagedoor");

            }
        });
        addService.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                GF.change("addservice");
            }
        });

    }

}

