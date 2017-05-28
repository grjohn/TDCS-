package com.execution;
import com.blocklist.*;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;  
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.util.TimerTask; 

public class ִ�д��� extends JFrame{
	
	
	public ������ l1=new ������();
	public վ��ͼ zhanchangtu=new վ��ͼ(l1);
	private java.util.Timer timer = new java.util.Timer();
	
	public ִ�д���() throws InterruptedException{											//���崰�ڵĹ��캯��
		this.setTitle("������վվ��ͼ(�ֲ�)");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(1200, 550);
		this.setVisible(true);
		this.getContentPane().add(zhanchangtu, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		JPanel states = new JPanel();
		panel.add(states);
		states.setBackground(new Color(240, 240, 240));
		states.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		final JComboBox cbsuobi = new JComboBox();			//�������յ�ģ��
		cbsuobi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cbsuobi.getSelectedIndex()){
				case 0:l1.dg1.setblock(1-l1.dg1.getblock());;break;
				case 1:l1.dg2.setblock(1-l1.dg2.getblock());;break;
				case 2:l1.adg.setblock(1-l1.adg.getblock());;break;
				case 3:l1.xdg.setblock(1-l1.xdg.getblock());;break;
				case 4:l1.dg3.setblock(1-l1.dg3.getblock());;break;
				}
			}
		});
		cbsuobi.setModel(new DefaultComboBoxModel(new String[] {"dg1", "dg2", "adg", "xdg", "dc1"}));
		states.add(cbsuobi);
		
		final JComboBox cbkongxian = new JComboBox();		//������е�ģ��
		cbkongxian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cbkongxian.getSelectedIndex()){
				case 2:l1.dg1.setclean(1-l1.dg1.getclean());;break;
				case 3:l1.dg2.setclean(1-l1.dg2.getclean());;break;
				case 0:l1.adg.setclean(1-l1.adg.getclean());;break;
				case 1:l1.xdg.setclean(1-l1.xdg.getclean());;break;
				}
			}
		});
		cbkongxian.setModel(new DefaultComboBoxModel(new String[] {"adg", "xdg", "dg1", "dg2"}));
		states.add(cbkongxian);
		
		final JTextArea textstates = new JTextArea(6,30);
		textstates.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		textstates.setLineWrap(true);
		states.add(textstates);
		textstates.setText("-----ʵʱ��ʾ-----\r\n");
		
		final JComboBox cbdiaoche = new JComboBox();
		cbdiaoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cbdiaoche.getSelectedIndex()){
				case 0:
					
					try {
						textstates.append(l1.diaoched1_S1());
				} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();System.out.println("������������~����");
					}
					
				break;
				case 1:try {
						l1.diaoched1_S2();
					} catch (InterruptedException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}break;
				case 2:try {
						l1.diaoches1_d1();
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
					e2.printStackTrace();
					};break;
				case 3:try {
						l1.diaoches2_d1();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					};break;
				}
			}
			}
		);
		cbdiaoche.setModel(new DefaultComboBoxModel(new String[] {"d1\u81F3s1", "d1\u81F3s2", "s1\u81F3d1", "s2\u81F3d1"}));
		states.add(cbdiaoche);
		
		final JComboBox cblieche = new JComboBox();
		cblieche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cblieche.getSelectedIndex()){
				case 0:
					
					try {
						l1.cexianjiecheX_S1();
				} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();System.out.println("������������~����");
					}
					
				break;
				case 1:try {
						l1.zhengxianjiecheX_S2();
					} catch (InterruptedException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}break;
				case 2:try {
						l1.facheches1_x();
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
					e2.printStackTrace();
					};break;
				case 3:try {
						l1.facheches2_x();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					};break;
				}
			}
		});
		cblieche.setModel(new DefaultComboBoxModel(new String[] {"x\u81F3s1", "x\u81F3s2", "s1\u81F3x", "s2\u81F3x"}));
		states.add(cblieche);
//		l1.diaoched1_S1(ִ�д���.this);
		timer.schedule(new TimerTask() {  
	            @Override  
	            public void run() {  
	                repaint();  
	            }  
	        }, 0, 100); 
		
	}

	
	public static void main(String[] args) throws InterruptedException{
		ִ�д��� v1=new ִ�д���();
	}
	
	public class վ��ͼ extends JPanel{
	
	public վ��ͼ(������ l1){
		System.out.println("1st");
		this.setBackground(new Color(133,218,133));
	}
		
	public void paint(Graphics g2) {				//������վͼ�Ļ���
		super.paint(g2);
		float lny=50;float inx=200;int lnty=50;int intx=200;
		Graphics2D g=(Graphics2D)g2;
		BasicStroke stroke=new BasicStroke(5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
		g.setStroke(stroke);
		g.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		
		Line2D.Float line=new Line2D.Float(0+inx, 190+lny, 0+inx+80, 190+lny);			//xdg
		g.setColor(l1.xdg.getcolor());
		g.draw(line);g.drawString("xdg", 30+intx, 210+lnty);

		g.setColor(l1.x.getcolor());System.out.println(l1.x.getcolor());							//x
		g.fillOval(83+intx, 150+lnty, 40,40);
		if(l1.x.getcolor()==Color.orange) g.fillOval(123+intx, 150+lnty, 40, 40);
		
		line=new Line2D.Float(80+inx, 190+lny, 280+inx, 190+lny);	//adg
		g.setColor(l1.adg.getcolor());
		g.draw(line);g.drawString("adg", 170+intx, 210+lnty);
		

		g.setColor(l1.d1.getcolor());						//d1
		g.fillOval(286+intx, 150+lnty, 40,40);	
		
		if(l1.dc3.getdaily()==1){						//��λ
			line=new Line2D.Float(286+inx, 190+lny, 546+inx, 190+lny);	//dg3��λ��·
			g.setColor(l1.dg3.getcolor());
			g.draw(line);
			line=new Line2D.Float(400+inx, 180+lny, 546+inx, 90+lny);	//dg3��λ��·
			g.draw(line);g.drawString("1", 356+intx, 210+lnty);
		}
		if(l1.dc3.getdaily()==0){						//��λ
			line=new Line2D.Float(286+inx, 190+lny, 366+inx, 190+lny);	//dg3��λ��·
			g.setColor(l1.dg3.getcolor());
			g.draw(line);
			line=new Line2D.Float(366+inx, 190+lny, 546+inx, 90+lny);	//dg3��λ��·
			g.draw(line);g.drawString("1", 356+intx, 210+lnty);
		}			
		
		g.setColor(l1.s2.getcolor());
		g.fillOval(506+intx, 150+lnty, 40, 40);	//s2
		
		line=new Line2D.Float(549+inx, 190+lny, 749+inx, 190+lny);	//dg2
		g.setColor(l1.dg2.getcolor());
		g.draw(line);g.drawString("dg2", 639+intx, 210+lnty);
		
		g.setColor(l1.s1.getcolor());
		g.fillOval(506+intx, 50+lnty, 40, 40);	//s1
		
		line=new Line2D.Float(549+inx, 90+lny, 749+inx, 90+lny);	//dg1
		g.setColor(l1.dg1.getcolor());
		g.draw(line);g.drawString("dg1", 639+intx, 110+lnty);
		
		stroke=new BasicStroke(3,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL);
		g.setStroke(stroke);

		g.setColor(Color.black);
		line=new Line2D.Float(547+inx, 190+lny, 547+inx, 150+lny);g.drawString("s2", 547+intx, 147+lnty);	//s2����
		g.draw(line);
		line=new Line2D.Float(547+inx, 90+lny, 547+inx, 50+lny);g.drawString("s1", 547+intx, 47+lnty);	//s1����
		g.draw(line);
		line=new Line2D.Float(80+inx, 190+lny, 80+inx, 150+lny);g.drawString("x", 80+intx, 147+lnty);	//x����
		g.draw(line);
		line=new Line2D.Float(283+inx, 190+lny, 283+inx, 150+lny);g.drawString("d1", 283+intx, 147+lnty);	//d1����
		g.draw(line);
		System.out.println("2rd");
	}
	
	}
	
}

	
	
