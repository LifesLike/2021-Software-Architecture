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

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
/*	Container frame = this.getContentPane();   //메인 컨테이너 객체 
	CardLayout card = new CardLayout();
	Color color = new Color(204, 255, 153, 200);
	ImageIcon imgicon = new ImageIcon("img/UI_Mark.jpg");
	Image img = imgicon.getImage();
	public GUI()
    {this("7조 SA Project");}
    
	public GUI(String title) {
		super(title);

		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(card);
		
		init();
		this.setVisible(true);
	}
// 각 기능 클래스 패널을 카드레이아웃 형테인 frame 에 부착하고, "home", "addservice"  등으로 지정해준다. 
	public void init() {  
		homePanel homepanel = new homePanel();
		addservicePanel add = new addservicePanel();
		garagedoorPanel gp = new garagedoorPanel();
		
		 frame.add(homepanel, "home");
		 frame.add(add,"addservice");
		 frame.add(gp, "garagedoor");
	}
	
//메인 화면을 구성하는 클래스 이다. 
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
					card.show(frame, "garagedoor");
				}
			});
			addService.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					card.show(frame, "addservice");
				}
			});

		}

	}
// 메인화면에서  GarageDoor 버튼을 눌렀을시 나타나는 화면을 구성하는 클래스이다.
	class garagedoorPanel extends JPanel {
		JButton open = new JButton("Door Open");
		JButton close = new JButton("Door Close");
		JButton stop = new JButton("Door Stop");
		JButton home = new JButton("Home");
		public void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);

			g.drawImage(img, 80, 100, 130, 120, null);

		}

		public garagedoorPanel() {
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
					card.show(frame, "home");
				}
			});

		}

	}
// 메인화면에서  AddService 버튼을 눌렀을시 나타나는 화면을 구성하는 클래스이다.
	class addservicePanel extends JPanel
	{public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		g.drawImage(img, 80, 100, 130, 120, null);

	}
	JButton home = new JButton("Home");
		public addservicePanel()
		{setLayout(new FlowLayout());
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
					card.show(frame, "home");
				}
			});
			
		}		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
		}
	
*/
}
