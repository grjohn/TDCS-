package com.blocklist;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar; 

import com.model.*;

public class 连锁表 {
	public final long time=1000;			//列车的行驶速度时间
	public 调车信号机 d1;
	public 出站兼调车信号机 s1,s2;
	public 进站信号机 x;
	public 道岔 dc3;
	public 股道 adg,dg1,dg2,dg3,xdg;
	private int hour,second,minute;
	public 连锁表(){
		d1= new 调车信号机();
		s1= new 出站兼调车信号机();
		s2= new 出站兼调车信号机();
		x= new 进站信号机();
		dc3=new 道岔();
		adg=new 股道();		dg1=new 股道();		 dg2=new 股道();		dg3=new 股道();	
		xdg=new 股道();xdg.setclean(0);			//初始xdg股道上有车
	}
	private void setCurrentTime() {  
        Calendar calendar = new GregorianCalendar();  
        hour = calendar.get(Calendar.HOUR_OF_DAY);  
        minute = calendar.get(Calendar.MINUTE);  
        second = calendar.get(Calendar.SECOND); 
	 }   
		public int getHour() {  
            return hour;  
        }  
  
        public int getMinute() {  
            return minute;  
        }  
  
        public int getSecond() {  
            return second;  
        }  
      
	public String zhengxianjiecheX_S2() throws InterruptedException{   //正线接车操作，涉及画图的页面刷新
		int a1=adg.getblock()+dc3.getblock()+dg2.getblock()+dg3.getblock();  //锁闭条件
		int a2=adg.getclean()+dg3.getclean()+dg2.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			Thread.sleep(time);	
			dc3.setdaily(1);			//定位状态
			adg.setblock(1);			//锁闭
			dc3.setblock(1);
			dg3.setblock(1);
			dg2.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"正线接车成功办理！列车开始行驶");
			x.setcolor(Color.yellow);d1.setcolor(Color.gray);  //灯光颜色转换
			Thread.sleep(2*time);
			adg.setclean(0);x.setcolor(Color.red);		//列车进入adg
			Thread.sleep(time);						
			xdg.setblock(0);						//列车出清xdg，自动解锁
			Thread.sleep(time);
			dg3.setclean(0);						//列车进入dg3
			Thread.sleep(time);
			adg.setblock(0);					//列车出清adg，自动解锁	
			Thread.sleep(time);
			dg2.setclean(0);						//列车占用dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg2.setblock(0);dg2.setclean(0);d1.setcolor(Color.blue);setCurrentTime();		//列车出清dg3,dg3,dc3,dg2同时解锁,列车到达dg2
			return hour+":"+minute+":"+second+"---"+"列车成功正线到达股道。";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"不可以办理正线接车";		
			}
	}
	public String diaoched1_S2() throws InterruptedException{   //d1至s2调车操作，涉及画图的页面刷新
		int a1=dc3.getblock()+dg3.getblock();  //锁闭条件
		int a2=dg3.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==1){
			Thread.sleep(time);	
			dc3.setdaily(1);			//定位状态
						//锁闭
			dc3.setblock(1);
			dg3.setblock(1);
			dg2.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"d1至s2调车成功办理！列车开始行驶");
			d1.setcolor(Color.white); //灯光颜色转换
			Thread.sleep(2*time);
			dg3.setclean(0);					//列车进入dg3
			Thread.sleep(time);
			adg.setblock(0);d1.setcolor(Color.blue);						//列车出清adg，自动解锁，调车信号机变蓝
			Thread.sleep(time);
			dg2.setclean(0);						//列车占用dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg2.setblock(0);dg2.setclean(0);setCurrentTime();		//列车出清dg3,dg3,dc3同时解锁,列车到达dg2
			return hour+":"+minute+":"+second+"---"+"列车成功由d1至s2调车。";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"不可以办理d1至s2调车";		
			}
	}
	
	public String facheches1_x() throws InterruptedException{   //侧线发车操作，涉及画图的页面刷新
		int a1=adg.getblock()+dc3.getblock()+xdg.getblock()+dg3.getblock();  //锁闭条件
		int a2=adg.getclean()+dg3.getclean()+xdg.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			Thread.sleep(time);	
			dc3.setdaily(0);			//定位状态
			adg.setblock(1);			//锁闭
			dc3.setblock(1);
			dg3.setblock(1);
			xdg.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"s1发车成功办理！列车开始行驶");
			s1.setcolor(Color.yellow);d1.setcolor(Color.gray);  //灯光颜色转换
			Thread.sleep(2*time);
			dg3.setclean(0);s1.setcolor(Color.red);		//列车进入dg3
			Thread.sleep(time);						
			dg1.setblock(0);					//列车出清dg1，自动解锁
			Thread.sleep(time);
			adg.setclean(0);						//列车进入adg
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);			//列车出清dg3，自动解锁	
			Thread.sleep(time);
			xdg.setclean(0);						//列车占用xdg
			Thread.sleep(time);
			xdg.setblock(0);d1.setcolor(Color.blue);setCurrentTime();		//列车出清xdg同时解锁,列车到达dg2
			return hour+":"+minute+":"+second+"---"+"列车成功由s1驶离出站。";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"不可以办理侧线发车";		
			}
	}
	
	public String diaoches1_d1() throws InterruptedException{   //s1至d1调车操作，涉及画图的页面刷新
		int a1=dc3.getblock()+dg3.getblock();  //锁闭条件
		int a2=dg3.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==1){
			Thread.sleep(time);	
			dc3.setdaily(0);			//定位状态
			adg.setblock(1);			//锁闭
			dc3.setblock(1);
			dg3.setblock(1);
			setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"s1至d1调车成功办理！列车开始行驶");
			s1.setcolor(Color.white);d1.setcolor(Color.red); //灯光颜色转换
			Thread.sleep(2*time);
			dg3.setclean(0);	//列车进入dg3
			Thread.sleep(time);						
			dg1.setblock(0);s1.setcolor(Color.red);							//列车出清dg1，自动解锁
			Thread.sleep(time);
			adg.setclean(0);						//列车进入adg
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);adg.setblock(0);			//列车出清dg3，自动解锁	
			d1.setcolor(Color.blue);setCurrentTime();		//列车出清xdg同时解锁,列车到达dg2
			return hour+":"+minute+":"+second+"---"+"列车成功由s1至d1调车。";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"不可以办理s1至d1调车";		
			}
	}
	
	public String facheches2_x() throws InterruptedException{   //正线发车操作，涉及画图的页面刷新
		int a1=adg.getblock()+dc3.getblock()+xdg.getblock()+dg3.getblock();  //锁闭条件
		int a2=adg.getclean()+dg3.getclean()+xdg.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			Thread.sleep(time);	
			dc3.setdaily(1);			//定位状态
			adg.setblock(1);			//锁闭
			dc3.setblock(1);
			dg3.setblock(1);
			xdg.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"s2发车成功办理！列车开始行驶");
			s2.setcolor(Color.yellow);d1.setcolor(Color.gray);  //灯光颜色转换
			Thread.sleep(2*time);
			dg3.setclean(0);s2.setcolor(Color.red);		//列车进入dg3
			Thread.sleep(time);						
			dg2.setblock(0);					//列车出清dg2，自动解锁
			Thread.sleep(time);
			adg.setclean(0);					//列车进入adg
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);			//列车出清dg3，自动解锁	
			Thread.sleep(time);
			xdg.setclean(0);						//列车占用xdg
			Thread.sleep(time);
			xdg.setblock(0);d1.setcolor(Color.blue);setCurrentTime();		//列车出清xdg同时解锁,列车到达dg2
			return hour+":"+minute+":"+second+"---"+"列车成功由s2驶离出站。";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"不可以办理正线发车";		
			}
	}
	
	public String diaoches2_d1() throws InterruptedException{   //s2至d1调车操作，涉及画图的页面刷新
		int a1=dc3.getblock()+dg3.getblock();  //锁闭条件
		int a2=dg3.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==1){
			Thread.sleep(time);	
			dc3.setdaily(1);			//定位状态
			dc3.setblock(1);
			dg3.setblock(1);
			setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"s2至d1调车办理！列车开始行驶");
			s2.setcolor(Color.white);d1.setcolor(Color.red); //灯光颜色转换
			Thread.sleep(2*time);
			dg3.setclean(0);s2.setcolor(Color.red);	//列车进入dg3
			Thread.sleep(time);						
			dg2.setblock(0);						//列车出清dg2，自动解锁
			Thread.sleep(time);
			adg.setclean(0);						//列车进入adg
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);adg.setblock(0);			//列车出清dg3，自动解锁	
			d1.setcolor(Color.blue);setCurrentTime();	//列车出清xdg同时解锁,列车到达dg2
			return hour+":"+minute+":"+second+"---"+"列车成功由s2至d1调车。";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"不可以办理s2至d1调车";		
			}
	}
	
	public void reset(){
		d1= new 调车信号机();
		s1= new 出站兼调车信号机();
		s2= new 出站兼调车信号机();
		x= new 进站信号机();
		dc3=new 道岔();
		adg=new 股道();		dg1=new 股道();		 dg2=new 股道();		dg3=new 股道();	
		xdg=new 股道();xdg.setclean(0);	
	}
	
	public String cexianjiecheX_S1() throws InterruptedException{   //侧线接车操作，涉及画图的页面刷新
		int a1=adg.getblock()+dc3.getblock()+dg1.getblock()+dg3.getblock();  //锁闭条件
		int a2=adg.getclean()+dg3.getclean()+dg1.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			//j.repaint();
			Thread.sleep(time);	
			dc3.setdaily(0);			//定位状态
			adg.setblock(1);			//锁闭
			dc3.setblock(1);
			dg3.setblock(1);
			dg1.setblock(1);setCurrentTime();
			//j.repaint();
			System.out.println(hour+":"+minute+":"+second+"---"+"侧线接车成功办理！列车开始行驶");
			x.setcolor(new Color(255,255,1,255));d1.setcolor(Color.gray); //灯光颜色转换
			Thread.sleep(2*time);
			adg.setclean(0);x.setcolor(Color.red);
			//j.repaint();		//列车进入adg
			Thread.sleep(time);						
			xdg.setblock(0);
			//j.repaint();						//列车出清xdg，自动解锁
			Thread.sleep(time);
			dg3.setclean(0);
			//j.repaint();						//列车进入dg3
			Thread.sleep(time);
			adg.setblock(0);
			//j.repaint();						//列车出清adg，自动解锁	
			Thread.sleep(time);
			dg1.setclean(0);
		//	j.repaint();						//列车占用dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg1.setblock(0);dg1.setclean(0);d1.setcolor(Color.blue);setCurrentTime();
		//	j.repaint();		//列车出清dg3,dg3,dc3,dg2同时解锁,列车到达dg2
			return hour+":"+minute+":"+second+"---"+"列车成功侧线到达股道。";
		}
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"不可以办理侧线接车";
			}
	}
	
	public String diaoched1_S1(){   //d1至s1调车操作，涉及画图的页面刷新
		int a1=dc3.getblock()+dg3.getblock();  //锁闭条件
		int a2=dg1.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==1){
		//	Thread.sleep(time);	
			定时1秒 d=new 定时1秒();
			d.dengdai1miao();
			dc3.setdaily(0);			//定位状态
			adg.setblock(1);			//锁闭
			dc3.setblock(1);
			dg3.setblock(1);
			dg1.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"d1至s1调车成功办理！列车开始行驶");
			d1.setcolor(Color.white);  //灯光颜色转换j.repaint();
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			d=new 定时1秒();d.dengdai1miao();
			dg3.setclean(0);				//列车进入dg3
		//	Thread.sleep(time);
			d=new 定时1秒();d.dengdai1miao();
			adg.setblock(0);					//列车出清adg，自动解锁	
		//	Thread.sleep(time);
			d=new 定时1秒();d.dengdai1miao();
			dg1.setclean(0);				//列车占用dg1
		//	Thread.sleep(time);
			d=new 定时1秒();d.dengdai1miao();
			dg3.setblock(0);dc3.setblock(0);dg1.setblock(0);dg1.setclean(0);d1.setcolor(Color.blue);setCurrentTime();	//列车出清dg3,dg3,dc3,dg2同时解锁,列车到达dg2
			return hour+":"+minute+":"+second+"---"+"列车成功由d1至s1调车。";
		}
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"不可以办理d1至s1调车";
			}
	}
	
	}
