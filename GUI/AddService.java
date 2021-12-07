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

public class AddService extends JFrame {
	Container frame = this.getContentPane(); // 메인 컨테이너 객체
	Color color = new Color(204, 255, 153, 200);
	ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
	Image img = imgicon.getImage();
	JButton home = new JButton("Home");
	JPanel panel = new JPanel();

	public AddService(String title) {
		super(title);

		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setLayout(null);
		init();
		this.setVisible(true);

	}

	public void init() {
		add(new addservicePanel());
	}

	class addservicePanel extends JPanel {
		public void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);

			g.drawImage(img, 80, 100, 130, 120, null);

		}

		JButton home = new JButton("Home");

		public addservicePanel() {
			setLayout(new FlowLayout());
			setBackground(color);
			add(new JLabel("연결 코드 "));
			JTextField tf = new JTextField(20);
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
					setVisible(false);
					new Home("7조 SA Project");
				}
			});

		}

	}
}
