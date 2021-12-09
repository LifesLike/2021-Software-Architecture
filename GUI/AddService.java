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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddService extends JPanel {

	Color color = new Color(204, 255, 153, 200);
	ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
	Image img = imgicon.getImage();
	private GUIFrame GF;

	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		g.drawImage(img, 80, 100, 130, 120, null);

	}

	public AddService(GUIFrame GF) {
		this.GF = GF;

		setLayout(new FlowLayout());
		setBackground(color);
		add(new JLabel("연결 코드 "));
		JTextField tf = new JTextField(20);
		JButton home = new JButton("Home");
		add(tf);
		add(home);

		// 텍스트필드에 연결코드를 쳤을시,
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String protocol = tf.getText();
				System.out.println(protocol);
				tf.setText("");

			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// setVisible(false);
				GF.change("home");
			}
		});

	}

}

