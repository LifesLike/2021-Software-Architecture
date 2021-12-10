package FinalProject.smarthome;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

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
		JButton home = new JButton("Home");
		setLayout(new FlowLayout());
		setBackground(color);
		add(open);
		add(close);
		add(stop);
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
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GF.change("home");

			}
		});

	}

}
