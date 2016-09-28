package boomgame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;



public class gaming extends JFrame {
	static int num2;
	public static  void getnum(int num) {
		num2 = num;	
	}
	private JPanel contentPane;
	String viewboomnum = "旗子剩餘數量：";
	JLabel boomcount = new JLabel();
	JLabel rule = new JLabel();
	JLabel rule1 = new JLabel();
	JLabel rule2 = new JLabel();
	JLabel rule3 = new JLabel();
	JLabel rule4 = new JLabel();
	JLabel rule5 = new JLabel();
	JButton push[][] = new JButton[num2][num2];
	ImageIcon boom = new ImageIcon("boom.png");
	ImageIcon pushed = new ImageIcon("pushed.png");
	ImageIcon default1 = new ImageIcon("default.png");
	ImageIcon one = new ImageIcon("1.png");
	ImageIcon two = new ImageIcon("2.png");
	ImageIcon three = new ImageIcon("3.png");
	ImageIcon four = new ImageIcon("4.png");
	ImageIcon five = new ImageIcon("5.png");
	ImageIcon six = new ImageIcon("6.png");
	ImageIcon seven = new ImageIcon("7.png");
	ImageIcon eight = new ImageIcon("8.png");
	ImageIcon flag = new ImageIcon("flag.png");
	int c = 0;
	boolean type[][] = new boolean[num2][num2];
	boolean boomloc[][] = new boolean[num2][num2];
	int count = (((num2 * num2) / 8) + 2), loc1, loc2;
	int direct[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
	int count2 = count;
	int count3 = count;
	int count4 = count;
	
	gaming() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200 + (15 * num2), 100 + (25 * num2));
		setLocationRelativeTo(this);
		setTitle("遊戲中");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		boomcount.setBounds(25 + (num2 * 20), 30, 105, 100);
		boomcount.setText(viewboomnum + count);
		contentPane.add(boomcount);
		rule.setBounds(25 + (num2 * 20), 40, 105, 150);
		rule.setText("規則：");
		contentPane.add(rule);
		rule1.setBounds(25 + (num2 * 20), 60, 105, 150);
		rule1.setText("滑鼠左鍵翻牌");
		contentPane.add(rule1);
		rule2.setBounds(25 + (num2 * 20), 80, 105, 150);
		rule2.setText("滑鼠右鍵設置旗子");
		contentPane.add(rule2);
		rule3.setBounds(25 + (num2 * 20), 100, 105, 150);
		rule3.setText("滑鼠中鍵回復預設");
		contentPane.add(rule3);
		rule4.setBounds(15, ((num2 * 20)-5), 300, 150);
		rule4.setText("*旗子與地雷位置全數相同即可獲勝");
		contentPane.add(rule4);
		rule5.setBounds(15, (10+(num2 * 20)), 300, 150);
		rule5.setText("*踩中地雷遊戲結束");
		contentPane.add(rule5);
		do {
			loc1 = function.setboom(num2);
			loc2 = function.setboom(num2);

			if (boomloc[loc1][loc2] == false) {
				boomloc[loc1][loc2] = true;
				count--;
			}
		} while (count != 0);

		for (int a = 0; a < num2; a++)
			for (int i = 0; i < num2; i++) {
				push[a][i] = new JButton();
				push[a][i].setBounds((15 + (a * 20)), (60 + (i * 20)), 20, 20);
				push[a][i].setIcon(default1);
				contentPane.add(push[a][i]);
			}

		for (int j = 0; j < num2; j++)
			for (int k = 0; k < num2; k++) {
				int stempj = j;
				int stempk = k;
				push[j][k].addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {

						if (e.getButton() == MouseEvent.BUTTON2) {
							if (type[stempj][stempk] == true && push[stempj][stempk].getIcon() == flag) {
								push[stempj][stempk].setIcon(default1);
								type[stempj][stempk] = false;
								count3++;
								count2 = count4-aroundboom();
								boomcount.setText(viewboomnum + count3);
							}
						}

						if (e.getButton() == MouseEvent.BUTTON3) {
							if (type[stempj][stempk] == false && count3 > 0) {
								push[stempj][stempk].setIcon(flag);
								type[stempj][stempk] = true;
								count3--;
								count2 = count4-aroundboom();
								if(count2>=0){
									boomcount.setText(viewboomnum + count3);
								}
								if (count2==0){
									JOptionPane.showMessageDialog(null," ＹＯＵ　ＷＩＮ");
									close();
								}
							}
						}
					}

					private int aroundboom() {
						int nownum = 0;
						for (int i = 0; i < boomloc.length; i++)
							for (int j = 0; j < boomloc.length; j++) {
								if (boomloc[i][j] == true && push[i][j].getIcon() == flag)
									nownum++;
							}
						return nownum;

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

					}
				});

				push[j][k].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (boomloc[stempj][stempk] == true && type[stempj][stempk] != true) {
							push[stempj][stempk].setIcon(boom);
							for (int a = 0; a < num2; a++)
								for (int b = 0; b < num2; b++)
									if (boomloc[a][b] == true)
										push[a][b].setIcon(boom);
							JOptionPane.showMessageDialog(null, "ＧＡＭＥ　ＯＶＥＲ");
							close();
						} else {
							action(stempj, stempk);
						}

					}

					public void action(int stempj, int stempk) {
						if (type[stempj][stempk] == false) {
							type[stempj][stempk] = true;

							switch (function.find(stempj, stempk, c, boomloc)) {

							case 0:
								push[stempj][stempk].setIcon(pushed);
								for (int dx = 0; dx < 4; dx++) {
									if (stempj + direct[dx][0] >= 0 && stempj + direct[dx][0] < boomloc.length
											&& stempk + direct[dx][1] >= 0 && stempk + direct[dx][1] < boomloc.length)
										action(stempj + direct[dx][0], stempk + direct[dx][1]);
								}
								break;
							case 1:
								if (push[stempj][stempk].getIcon() != flag)
									push[stempj][stempk].setIcon(one);
								break;
							case 2:
								if (push[stempj][stempk].getIcon() != flag)
									push[stempj][stempk].setIcon(two);
								break;
							case 3:
								if (push[stempj][stempk].getIcon() != flag)
									push[stempj][stempk].setIcon(three);
								break;
							case 4:
								if (push[stempj][stempk].getIcon() != flag)
									push[stempj][stempk].setIcon(four);
								break;
							case 5:
								if (push[stempj][stempk].getIcon() != flag)
									push[stempj][stempk].setIcon(five);
								break;
							case 6:
								if (push[stempj][stempk].getIcon() != flag)
									push[stempj][stempk].setIcon(six);
								break;
							case 7:
								if (push[stempj][stempk].getIcon() != flag)
									push[stempj][stempk].setIcon(seven);
								break;
							case 8:
								if (push[stempj][stempk].getIcon() != flag)
									push[stempj][stempk].setIcon(eight);
								break;
							}

						}
					}
				});
			}
		
		setVisible(true);
	}

	protected void close() {
		this.dispose();
	}

}
