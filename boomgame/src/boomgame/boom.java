package boomgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class MyJFrame extends JFrame {
	private JPanel contentPane;
	private JRadioButton seven, eight, nine;
	private JButton play;
	public  int num;

	MyJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(this);
		setTitle("踩地雷");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		seven = new JRadioButton("7*7");
		// seven.setBackground(Color.black);
		seven.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gaming.num2 = 7;
				num = gaming.num2;
			}
		});
		seven.setBounds(200, 20, 45, 20);
		contentPane.add(seven);

		eight = new JRadioButton("8*8");
		// eight.setBackground(Color.black);
		eight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gaming.num2 = 8;
				num = gaming.num2;
			}
		});

		eight.setBounds(200, 70, 45, 20);
		contentPane.add(eight);
		nine = new JRadioButton("9*9");
		// nine.setBackground(Color.black);
		nine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gaming.num2 = 9;
				num = gaming.num2;
				gaming.getnum(num);
			}


		});

		nine.setBounds(200, 120, 45, 20);
		contentPane.add(nine);

		ButtonGroup group = new ButtonGroup();
		group.add(seven);
		group.add(eight);
		group.add(nine);

		play = new JButton("PLAY");
		// play.setBackground(Color.black);
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (num == 0)
					JOptionPane.showMessageDialog(null, "87要選模式");
				else {
					gaming gamewin = new gaming();
					close();
				}
			}

		});
		play.setBounds(180, 170, 100, 25);
		contentPane.add(play);
		setVisible(true);
	}

	protected void close() {
		this.dispose();
	}
}

public class boom {

	public static void main(String[] args) {
		MyJFrame choice = new MyJFrame();

	}

}
