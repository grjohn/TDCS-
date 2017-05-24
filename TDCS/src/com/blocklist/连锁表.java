package com.blocklist;
import com.model.*;
import com.execution.*;
public class 连锁表 {
	public final long time=5;
	public 调车信号机 d1;
	public 出站兼调车信号机 s1,s2;
	public 进站信号机 x;
	public 道岔 dc3;
	public 股道 adg,dg1,dg2,dg3,xdg;
	public 连锁表(){
		d1= new 调车信号机();
		s1= new 出站兼调车信号机();
		s2= new 出站兼调车信号机();
		x= new 进站信号机();
		dc3=new 道岔();
		adg=new 股道();		dg1=new 股道();		 dg2=new 股道();		dg3=new 股道();	
		xdg=new 股道();xdg.setclean(0);			//初始xdg股道上有车
	}
	public String zhengxianjiecheX_S2() throws InterruptedException{   //接车操作，不涉及画图
		int a1=adg.getblock()+dc3.getblock()+dg2.getblock()+dg3.getblock();  //锁闭条件
		int a2=adg.getclean()+dg3.getclean()+dg2.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			dc3.setdaily(1);			//定位状态
			adg.setblock(1);			//锁闭
			dc3.setblock(1);
			dg3.setblock(1);
			dg2.setblock(1);
			System.out.println("正线接车成功办理！列车开始行驶");
			x.setcolor("黄");d1.setcolor("灭灯");  //灯光颜色转换
			Thread.sleep(2*time);
			adg.setclean(0);x.setcolor("红");		//列车进入adg
			Thread.sleep(time);						
			xdg.setblock(0);						//列车出清xdg，自动解锁
			Thread.sleep(time);
			dg3.setclean(0);						//列车进入dg3
			Thread.sleep(time);
			adg.setblock(0);						//列车出清adg，自动解锁	
			Thread.sleep(time);
			dg2.setclean(0);						//列车占用dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg2.setblock(0);dg2.setclean(0);		//列车出清dg3,dg3,dc3,dg2同时解锁,列车到达dg2
			return "列车成功正线到达股道。";
		}
		else
			return "不可以办理正线接车";		
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
	
	public String cexianjiecheX_S1() throws InterruptedException{   //接车操作，不涉及画图
		int a1=adg.getblock()+dc3.getblock()+dg1.getblock()+dg3.getblock();  //锁闭条件
		int a2=adg.getclean()+dg3.getclean()+dg1.getclean();  //空闲条件
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			dc3.setdaily(0);			//定位状态
			adg.setblock(1);			//锁闭
			dc3.setblock(1);
			dg3.setblock(1);
			dg1.setblock(1);
			System.out.println("侧线接车成功办理！列车开始行驶");
			x.setcolor("黄");d1.setcolor("灭灯");  //灯光颜色转换
			Thread.sleep(2*time);
			adg.setclean(0);x.setcolor("红");		//列车进入adg
			Thread.sleep(time);						
			xdg.setblock(0);						//列车出清xdg，自动解锁
			Thread.sleep(time);
			dg3.setclean(0);						//列车进入dg3
			Thread.sleep(time);
			adg.setblock(0);						//列车出清adg，自动解锁	
			Thread.sleep(time);
			dg1.setclean(0);						//列车占用dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg1.setblock(0);dg1.setclean(0);		//列车出清dg3,dg3,dc3,dg2同时解锁,列车到达dg2
			return "列车成功侧线到达股道。";
		}
		else
			return "不可以办理侧线接车";
	}
	}
