package com.execution;
import com.blocklist.*;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;  
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class 执行窗体 extends JFrame{
	
	
	public 连锁表 l1=new 连锁表();
	public 站场图 zhanchangtu=new 站场图(l1);
	
	public 执行窗体() throws InterruptedException{											//整体窗口的构造函数
		this.setTitle("北京西站站场图(局部)");
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
		
		JTextArea textstates = new JTextArea(6,30);
		textstates.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textstates.setLineWrap(true);
		states.add(textstates);
		textstates.setText("-----实时显示-----\r\n");
		textstates.append(l1.cexianjiecheX_S1(this));	
//	public 执行窗体() throws InterruptedException{											//整体窗口的构造函数
//		this.setTitle("北京西站站场图(局部)");
//		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//		this.setSize(1200, 900);
//		this.setVisible(true);
//		JPanel states = new JPanel();
//		this.repaint();
//		states.setBackground(new Color(240, 240, 240));
//		this.getContentPane().add(states, BorderLayout.SOUTH);
//		states.setLayout(new BorderLayout(0, 0));
//		
//		JPanel panel = new JPanel();
//		states.add(panel);
//		
//		JTextArea textstates = new JTextArea(6,30);
//		panel.add(textstates);
//		textstates.setFont(new Font("微软雅黑", Font.PLAIN, 17));
//		textstates.setLineWrap(true);
//		
////		JComboBox cbdiaoche = new JComboBox();
////		panel.add(cbdiaoche);
////		cbdiaoche.setModel(new DefaultComboBoxModel(new String[] {"d1\u81F3s1", "d1\u81F3s2", "s1\u81F3d1", "s2\u81F3d2"}));
////		zhanchangtu.repaint();
////		JComboBox cblieche = new JComboBox();
////		panel.add(cblieche);
////
////		cblieche.setModel(new DefaultComboBoxModel(new String[] {"x\u81F3s1", "x\u81F3s2", "s1\u81F3x", "s2\u81F3x"}));
//				textstates.setText(l1.diaoched1_S1(this)+"\r\n");
////				textstates.append("1234");
//		this.getContentPane().add(zhanchangtu, BorderLayout.CENTER);
//	
//	//repaint();
//	//textstates.append(l1.diaoched1_S2());	
//	}
	}

	
	public static void main(String[] args) throws InterruptedException{
		执行窗体 v1=new 执行窗体();
	}
	
	public class 站场图 extends JPanel{
	
	public 站场图(连锁表 l1){
		System.out.println("1st");
		this.setBackground(new Color(133,218,133));
	}
		
	public void paint(Graphics g2) {				//整个场站图的绘制
		super.paint(g2);
		float lny=50;float inx=200;int lnty=50;int intx=200;
		Graphics2D g=(Graphics2D)g2;
		BasicStroke stroke=new BasicStroke(5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
		g.setStroke(stroke);
		g.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		Line2D.Float line=new Line2D.Float(0+inx, 190+lny, 0+inx+80, 190+lny);			//xdg
		g.setColor(l1.xdg.getcolor());
		g.draw(line);g.drawString("xdg", 30+intx, 210+lnty);

		g.setColor(l1.x.getcolor());System.out.println(l1.x.getcolor());							//x
		g.fillOval(83+intx, 150+lnty, 40,40);
		if(l1.x.getcolor()==new Color(255,255,1,255)) g.fillOval(123+intx, 150+lnty, 40, 40);
		
		line=new Line2D.Float(80+inx, 190+lny, 280+inx, 190+lny);	//adg
		g.setColor(l1.adg.getcolor());
		g.draw(line);g.drawString("adg", 170+intx, 210+lnty);
		

		g.setColor(l1.d1.getcolor());						//d1
		g.fillOval(286+intx, 150+lnty, 40,40);	
		
		if(l1.dc3.getdaily()==1){						//定位
			line=new Line2D.Float(286+inx, 190+lny, 546+inx, 190+lny);	//dg3定位线路
			g.setColor(l1.dg3.getcolor());
			g.draw(line);
			line=new Line2D.Float(400+inx, 180+lny, 546+inx, 90+lny);	//dg3反位线路
			g.draw(line);g.drawString("1", 356+intx, 210+lnty);
		}
		if(l1.dc3.getdaily()==0){						//反位
			line=new Line2D.Float(286+inx, 190+lny, 366+inx, 190+lny);	//dg3定位线路
			g.setColor(l1.dg3.getcolor());
			g.draw(line);
			line=new Line2D.Float(366+inx, 190+lny, 546+inx, 90+lny);	//dg3反位线路
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
		line=new Line2D.Float(547+inx, 190+lny, 547+inx, 150+lny);g.drawString("s2", 547+intx, 147+lnty);	//s2灯线
		g.draw(line);
		line=new Line2D.Float(547+inx, 90+lny, 547+inx, 50+lny);g.drawString("s1", 547+intx, 47+lnty);	//s1灯线
		g.draw(line);
		line=new Line2D.Float(80+inx, 190+lny, 80+inx, 150+lny);g.drawString("x", 80+intx, 147+lnty);	//x灯线
		g.draw(line);
		line=new Line2D.Float(283+inx, 190+lny, 283+inx, 150+lny);g.drawString("d1", 283+intx, 147+lnty);	//d1灯线
		g.draw(line);
		System.out.println("2rd");
	}
	
	}
	
}

	
	
