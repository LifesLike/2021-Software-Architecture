package homeautomation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Home extends JFrame {
	Container frame = this.getContentPane(); // 메인 컨테이너 객체
	CardLayout card = new CardLayout();
	Color color = new Color(204, 255, 153, 200);
	ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
	Image img = imgicon.getImage();
	JButton home = new JButton("Home");
	JPanel panel = new JPanel();
	
	public Home(String title)
	{super(title);

	this.setSize(300, 300);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	//this.setLayout(null);
	init();
	this.setVisible(true);}
	public void init()
	{frame.add(new homePanel());}
	
	class homePanel extends JPanel {
		public void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);

			g.drawImage(img, 80, 100, 130, 120, null);

		}

		JButton garageDoor = new JButton("GarageDoor");
		JButton addService = new JButton("AddService");

		public homePanel() {
			setLayout(new FlowLayout());
			setBackground(color);
			add(garageDoor);
			add(addService);

			garageDoor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new GarageDoor("7조 SA Project");
				}
			});
			addService.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new AddService("7조 SA Project");
				}
			});

		}

	}
}
