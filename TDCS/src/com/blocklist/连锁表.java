package com.blocklist;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar; 

import com.model.*;

public class ������ {
	public final long time=1000;			//�г�����ʻ�ٶ�ʱ��
	public �����źŻ� d1;
	public ��վ������źŻ� s1,s2;
	public ��վ�źŻ� x;
	public ���� dc3;
	public �ɵ� adg,dg1,dg2,dg3,xdg;
	private int hour,second,minute;
	public ������(){
		d1= new �����źŻ�();
		s1= new ��վ������źŻ�();
		s2= new ��վ������źŻ�();
		x= new ��վ�źŻ�();
		dc3=new ����();
		adg=new �ɵ�();		dg1=new �ɵ�();		 dg2=new �ɵ�();		dg3=new �ɵ�();	
		xdg=new �ɵ�();xdg.setclean(0);			//��ʼxdg�ɵ����г�
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
      
	public String zhengxianjiecheX_S2() throws InterruptedException{   //���߽ӳ��������漰��ͼ��ҳ��ˢ��
		int a1=adg.getblock()+dc3.getblock()+dg2.getblock()+dg3.getblock();  //��������
		int a2=adg.getclean()+dg3.getclean()+dg2.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			Thread.sleep(time);	
			dc3.setdaily(1);			//��λ״̬
			adg.setblock(1);			//����
			dc3.setblock(1);
			dg3.setblock(1);
			dg2.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"���߽ӳ��ɹ������г���ʼ��ʻ");
			x.setcolor(Color.yellow);d1.setcolor(Color.gray);  //�ƹ���ɫת��
			Thread.sleep(2*time);
			adg.setclean(0);x.setcolor(Color.red);		//�г�����adg
			Thread.sleep(time);						
			xdg.setblock(0);						//�г�����xdg���Զ�����
			Thread.sleep(time);
			dg3.setclean(0);						//�г�����dg3
			Thread.sleep(time);
			adg.setblock(0);					//�г�����adg���Զ�����	
			Thread.sleep(time);
			dg2.setclean(0);						//�г�ռ��dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg2.setblock(0);dg2.setclean(0);d1.setcolor(Color.blue);setCurrentTime();		//�г�����dg3,dg3,dc3,dg2ͬʱ����,�г�����dg2
			return hour+":"+minute+":"+second+"---"+"�г��ɹ����ߵ���ɵ���";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"�����԰������߽ӳ�";		
			}
	}
	public String diaoched1_S2() throws InterruptedException{   //d1��s2�����������漰��ͼ��ҳ��ˢ��
		int a1=dc3.getblock()+dg3.getblock();  //��������
		int a2=dg3.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==1){
			Thread.sleep(time);	
			dc3.setdaily(1);			//��λ״̬
						//����
			dc3.setblock(1);
			dg3.setblock(1);
			dg2.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"d1��s2�����ɹ������г���ʼ��ʻ");
			d1.setcolor(Color.white); //�ƹ���ɫת��
			Thread.sleep(2*time);
			dg3.setclean(0);					//�г�����dg3
			Thread.sleep(time);
			adg.setblock(0);d1.setcolor(Color.blue);						//�г�����adg���Զ������������źŻ�����
			Thread.sleep(time);
			dg2.setclean(0);						//�г�ռ��dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg2.setblock(0);dg2.setclean(0);setCurrentTime();		//�г�����dg3,dg3,dc3ͬʱ����,�г�����dg2
			return hour+":"+minute+":"+second+"---"+"�г��ɹ���d1��s2������";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"�����԰���d1��s2����";		
			}
	}
	
	public String facheches1_x() throws InterruptedException{   //���߷����������漰��ͼ��ҳ��ˢ��
		int a1=adg.getblock()+dc3.getblock()+xdg.getblock()+dg3.getblock();  //��������
		int a2=adg.getclean()+dg3.getclean()+xdg.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			Thread.sleep(time);	
			dc3.setdaily(0);			//��λ״̬
			adg.setblock(1);			//����
			dc3.setblock(1);
			dg3.setblock(1);
			xdg.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"s1�����ɹ������г���ʼ��ʻ");
			s1.setcolor(Color.yellow);d1.setcolor(Color.gray);  //�ƹ���ɫת��
			Thread.sleep(2*time);
			dg3.setclean(0);s1.setcolor(Color.red);		//�г�����dg3
			Thread.sleep(time);						
			dg1.setblock(0);					//�г�����dg1���Զ�����
			Thread.sleep(time);
			adg.setclean(0);						//�г�����adg
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);			//�г�����dg3���Զ�����	
			Thread.sleep(time);
			xdg.setclean(0);						//�г�ռ��xdg
			Thread.sleep(time);
			xdg.setblock(0);d1.setcolor(Color.blue);setCurrentTime();		//�г�����xdgͬʱ����,�г�����dg2
			return hour+":"+minute+":"+second+"---"+"�г��ɹ���s1ʻ���վ��";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"�����԰�����߷���";		
			}
	}
	
	public String diaoches1_d1() throws InterruptedException{   //s1��d1�����������漰��ͼ��ҳ��ˢ��
		int a1=dc3.getblock()+dg3.getblock();  //��������
		int a2=dg3.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==1){
			Thread.sleep(time);	
			dc3.setdaily(0);			//��λ״̬
			adg.setblock(1);			//����
			dc3.setblock(1);
			dg3.setblock(1);
			setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"s1��d1�����ɹ������г���ʼ��ʻ");
			s1.setcolor(Color.white);d1.setcolor(Color.red); //�ƹ���ɫת��
			Thread.sleep(2*time);
			dg3.setclean(0);	//�г�����dg3
			Thread.sleep(time);						
			dg1.setblock(0);s1.setcolor(Color.red);							//�г�����dg1���Զ�����
			Thread.sleep(time);
			adg.setclean(0);						//�г�����adg
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);adg.setblock(0);			//�г�����dg3���Զ�����	
			d1.setcolor(Color.blue);setCurrentTime();		//�г�����xdgͬʱ����,�г�����dg2
			return hour+":"+minute+":"+second+"---"+"�г��ɹ���s1��d1������";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"�����԰���s1��d1����";		
			}
	}
	
	public String facheches2_x() throws InterruptedException{   //���߷����������漰��ͼ��ҳ��ˢ��
		int a1=adg.getblock()+dc3.getblock()+xdg.getblock()+dg3.getblock();  //��������
		int a2=adg.getclean()+dg3.getclean()+xdg.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			Thread.sleep(time);	
			dc3.setdaily(1);			//��λ״̬
			adg.setblock(1);			//����
			dc3.setblock(1);
			dg3.setblock(1);
			xdg.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"s2�����ɹ������г���ʼ��ʻ");
			s2.setcolor(Color.yellow);d1.setcolor(Color.gray);  //�ƹ���ɫת��
			Thread.sleep(2*time);
			dg3.setclean(0);s2.setcolor(Color.red);		//�г�����dg3
			Thread.sleep(time);						
			dg2.setblock(0);					//�г�����dg2���Զ�����
			Thread.sleep(time);
			adg.setclean(0);					//�г�����adg
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);			//�г�����dg3���Զ�����	
			Thread.sleep(time);
			xdg.setclean(0);						//�г�ռ��xdg
			Thread.sleep(time);
			xdg.setblock(0);d1.setcolor(Color.blue);setCurrentTime();		//�г�����xdgͬʱ����,�г�����dg2
			return hour+":"+minute+":"+second+"---"+"�г��ɹ���s2ʻ���վ��";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"�����԰������߷���";		
			}
	}
	
	public String diaoches2_d1() throws InterruptedException{   //s2��d1�����������漰��ͼ��ҳ��ˢ��
		int a1=dc3.getblock()+dg3.getblock();  //��������
		int a2=dg3.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==1){
			Thread.sleep(time);	
			dc3.setdaily(1);			//��λ״̬
			dc3.setblock(1);
			dg3.setblock(1);
			setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"s2��d1���������г���ʼ��ʻ");
			s2.setcolor(Color.white);d1.setcolor(Color.red); //�ƹ���ɫת��
			Thread.sleep(2*time);
			dg3.setclean(0);s2.setcolor(Color.red);	//�г�����dg3
			Thread.sleep(time);						
			dg2.setblock(0);						//�г�����dg2���Զ�����
			Thread.sleep(time);
			adg.setclean(0);						//�г�����adg
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);adg.setblock(0);			//�г�����dg3���Զ�����	
			d1.setcolor(Color.blue);setCurrentTime();	//�г�����xdgͬʱ����,�г�����dg2
			return hour+":"+minute+":"+second+"---"+"�г��ɹ���s2��d1������";
		}
		
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"�����԰���s2��d1����";		
			}
	}
	
	public void reset(){
		d1= new �����źŻ�();
		s1= new ��վ������źŻ�();
		s2= new ��վ������źŻ�();
		x= new ��վ�źŻ�();
		dc3=new ����();
		adg=new �ɵ�();		dg1=new �ɵ�();		 dg2=new �ɵ�();		dg3=new �ɵ�();	
		xdg=new �ɵ�();xdg.setclean(0);	
	}
	
	public String cexianjiecheX_S1() throws InterruptedException{   //���߽ӳ��������漰��ͼ��ҳ��ˢ��
		int a1=adg.getblock()+dc3.getblock()+dg1.getblock()+dg3.getblock();  //��������
		int a2=adg.getclean()+dg3.getclean()+dg1.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			//j.repaint();
			Thread.sleep(time);	
			dc3.setdaily(0);			//��λ״̬
			adg.setblock(1);			//����
			dc3.setblock(1);
			dg3.setblock(1);
			dg1.setblock(1);setCurrentTime();
			//j.repaint();
			System.out.println(hour+":"+minute+":"+second+"---"+"���߽ӳ��ɹ������г���ʼ��ʻ");
			x.setcolor(new Color(255,255,1,255));d1.setcolor(Color.gray); //�ƹ���ɫת��
			Thread.sleep(2*time);
			adg.setclean(0);x.setcolor(Color.red);
			//j.repaint();		//�г�����adg
			Thread.sleep(time);						
			xdg.setblock(0);
			//j.repaint();						//�г�����xdg���Զ�����
			Thread.sleep(time);
			dg3.setclean(0);
			//j.repaint();						//�г�����dg3
			Thread.sleep(time);
			adg.setblock(0);
			//j.repaint();						//�г�����adg���Զ�����	
			Thread.sleep(time);
			dg1.setclean(0);
		//	j.repaint();						//�г�ռ��dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg1.setblock(0);dg1.setclean(0);d1.setcolor(Color.blue);setCurrentTime();
		//	j.repaint();		//�г�����dg3,dg3,dc3,dg2ͬʱ����,�г�����dg2
			return hour+":"+minute+":"+second+"---"+"�г��ɹ����ߵ���ɵ���";
		}
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"�����԰�����߽ӳ�";
			}
	}
	
	public String diaoched1_S1(){   //d1��s1�����������漰��ͼ��ҳ��ˢ��
		int a1=dc3.getblock()+dg3.getblock();  //��������
		int a2=dg1.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==1){
		//	Thread.sleep(time);	
			��ʱ1�� d=new ��ʱ1��();
			d.dengdai1miao();
			dc3.setdaily(0);			//��λ״̬
			adg.setblock(1);			//����
			dc3.setblock(1);
			dg3.setblock(1);
			dg1.setblock(1);setCurrentTime();
			System.out.println(hour+":"+minute+":"+second+"---"+"d1��s1�����ɹ������г���ʼ��ʻ");
			d1.setcolor(Color.white);  //�ƹ���ɫת��j.repaint();
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			d=new ��ʱ1��();d.dengdai1miao();
			dg3.setclean(0);				//�г�����dg3
		//	Thread.sleep(time);
			d=new ��ʱ1��();d.dengdai1miao();
			adg.setblock(0);					//�г�����adg���Զ�����	
		//	Thread.sleep(time);
			d=new ��ʱ1��();d.dengdai1miao();
			dg1.setclean(0);				//�г�ռ��dg1
		//	Thread.sleep(time);
			d=new ��ʱ1��();d.dengdai1miao();
			dg3.setblock(0);dc3.setblock(0);dg1.setblock(0);dg1.setclean(0);d1.setcolor(Color.blue);setCurrentTime();	//�г�����dg3,dg3,dc3,dg2ͬʱ����,�г�����dg2
			return hour+":"+minute+":"+second+"---"+"�г��ɹ���d1��s1������";
		}
		else
			{
				setCurrentTime();
				return hour+":"+minute+":"+second+"---"+"�����԰���d1��s1����";
			}
	}
	
	}
