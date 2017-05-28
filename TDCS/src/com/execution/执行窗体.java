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
import java.util.TimerTask; 

public class 执行窗体 extends JFrame{
	
	public JTextArea textstates;
	public 连锁表 l1=new 连锁表();
	public 站场图 zhanchangtu=new 站场图(l1);
	private java.util.Timer timer = new java.util.Timer();
	
	public 执行窗体() throws InterruptedException{											//整体窗口的构造函数		
		this.setTitle("北京西站站场图(菊部)");
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
		
				final JComboBox cbsuobi = new JComboBox();			//负责锁闭的模块
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
		
		final JComboBox cbkongxian = new JComboBox();		//负责空闲的模块
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
		
		textstates = new JTextArea(6,30);
		textstates.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textstates.setLineWrap(true);
		textstates.setText("-----实时显示-----\r\n");
		
		final JComboBox cblieche = new JComboBox();
		cblieche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cblieche.getSelectedIndex()){
				case 0:
					
					try {
						l1.cexianjiecheX_S1(textstates);
				} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();System.out.println("出错！！！！！~！！");
					}
					
				break;
				case 1:try {
						l1.zhengxianjiecheX_S2(textstates);
					} catch (InterruptedException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}break;
				case 2:try {
						l1.facheches1_x(textstates);
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
					e2.printStackTrace();
					};break;
				case 3:try {
						l1.facheches2_x(textstates);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					};break;
				}
			}
		});
		
		final JComboBox cbdiaoche = new JComboBox();
		cbdiaoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cbdiaoche.getSelectedIndex()){
				case 0:
					
					try {
						l1.diaoched1_S1(textstates);
				} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();System.out.println("出错！！！！！~！！");
					}
					
				break;
				case 1:try {
						l1.diaoched1_S2(textstates);
					} catch (InterruptedException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}break;
				case 2:try {
						l1.diaoches1_d1(textstates);
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
					e2.printStackTrace();
					};break;
				case 3:try {
						l1.diaoches2_d1(textstates);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					};break;
				}
			}
			}
		);
		cbdiaoche.setModel(new DefaultComboBoxModel(new String[] {"d1\u81F3s1", "d1\u81F3s2", "s1\u81F3d1", "s2\u81F3d1"}));
		cblieche.setModel(new DefaultComboBoxModel(new String[] {"x\u81F3s1", "x\u81F3s2", "s1\u81F3x", "s2\u81F3x"}));
		
		JLabel lblNewLabel = new JLabel("\u9501\u95ED");
		
		JLabel lblNewLabel_1 = new JLabel("\u7A7A\u95F2");
		
		JLabel lblNewLabel_2 = new JLabel("\u8C03\u8F66");
		
		JLabel lblNewLabel_3 = new JLabel("\u63A5\u8F66\u53D1\u8F66");
		GroupLayout gl_states = new GroupLayout(states);
		gl_states.setHorizontalGroup(
			gl_states.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_states.createSequentialGroup()
					.addGroup(gl_states.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_states.createSequentialGroup()
							.addGap(214)
							.addComponent(cbsuobi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(cbkongxian, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5))
						.addGroup(Alignment.TRAILING, gl_states.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(27)
							.addComponent(lblNewLabel_1)
							.addGap(18)))
					.addComponent(textstates, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_states.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_states.createSequentialGroup()
							.addGap(5)
							.addComponent(cbdiaoche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_states.createSequentialGroup()
							.addGap(27)
							.addComponent(lblNewLabel_2)))
					.addGap(5)
					.addGroup(gl_states.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(cblieche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		gl_states.setVerticalGroup(
			gl_states.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_states.createSequentialGroup()
					.addGap(5)
					.addComponent(textstates, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_states.createSequentialGroup()
					.addGap(64)
					.addComponent(cbdiaoche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_states.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_states.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cblieche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_states.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_states.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_states.createParallelGroup(Alignment.LEADING)
						.addComponent(cbsuobi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbkongxian, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		states.setLayout(gl_states);
//		l1.diaoched1_S1(执行窗体.this);
		timer.schedule(new TimerTask() {  //定时器，刷新屏幕
	            @Override  
	            public void run() {  
	                repaint();  
	            }  
	        }, 0, 100); 
		
	
	}

	
	public static void main(String[] args) throws InterruptedException{
		执行窗体 v1=new 执行窗体();
	}
	
	public class 站场图 extends JPanel{
	
	public 站场图(连锁表 l1){
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

		g.setColor(l1.x.getcolor());							//x
		g.fillOval(83+intx, 150+lnty, 40,40);
		if(l1.x.getcolor()==Color.orange) g.fillOval(123+intx, 150+lnty, 40, 40);
		
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
	}
	
	}
}