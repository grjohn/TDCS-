package com.blocklist;
import com.model.*;
import com.execution.*;
public class ������ {
	public final long time=5;
	public �����źŻ� d1;
	public ��վ������źŻ� s1,s2;
	public ��վ�źŻ� x;
	public ���� dc3;
	public �ɵ� adg,dg1,dg2,dg3,xdg;
	public ������(){
		d1= new �����źŻ�();
		s1= new ��վ������źŻ�();
		s2= new ��վ������źŻ�();
		x= new ��վ�źŻ�();
		dc3=new ����();
		adg=new �ɵ�();		dg1=new �ɵ�();		 dg2=new �ɵ�();		dg3=new �ɵ�();	
		xdg=new �ɵ�();xdg.setclean(0);			//��ʼxdg�ɵ����г�
	}
	public String zhengxianjiecheX_S2() throws InterruptedException{   //�ӳ����������漰��ͼ
		int a1=adg.getblock()+dc3.getblock()+dg2.getblock()+dg3.getblock();  //��������
		int a2=adg.getclean()+dg3.getclean()+dg2.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			dc3.setdaily(1);			//��λ״̬
			adg.setblock(1);			//����
			dc3.setblock(1);
			dg3.setblock(1);
			dg2.setblock(1);
			System.out.println("���߽ӳ��ɹ������г���ʼ��ʻ");
			x.setcolor("��");d1.setcolor("���");  //�ƹ���ɫת��
			Thread.sleep(2*time);
			adg.setclean(0);x.setcolor("��");		//�г�����adg
			Thread.sleep(time);						
			xdg.setblock(0);						//�г�����xdg���Զ�����
			Thread.sleep(time);
			dg3.setclean(0);						//�г�����dg3
			Thread.sleep(time);
			adg.setblock(0);						//�г�����adg���Զ�����	
			Thread.sleep(time);
			dg2.setclean(0);						//�г�ռ��dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg2.setblock(0);dg2.setclean(0);		//�г�����dg3,dg3,dc3,dg2ͬʱ����,�г�����dg2
			return "�г��ɹ����ߵ���ɵ���";
		}
		else
			return "�����԰������߽ӳ�";		
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
	
	public String cexianjiecheX_S1() throws InterruptedException{   //�ӳ����������漰��ͼ
		int a1=adg.getblock()+dc3.getblock()+dg1.getblock()+dg3.getblock();  //��������
		int a2=adg.getclean()+dg3.getclean()+dg1.getclean();  //��������
		System.out.println(a1+" "+a2);
		if(a1==0&&a2==3){
			dc3.setdaily(0);			//��λ״̬
			adg.setblock(1);			//����
			dc3.setblock(1);
			dg3.setblock(1);
			dg1.setblock(1);
			System.out.println("���߽ӳ��ɹ������г���ʼ��ʻ");
			x.setcolor("��");d1.setcolor("���");  //�ƹ���ɫת��
			Thread.sleep(2*time);
			adg.setclean(0);x.setcolor("��");		//�г�����adg
			Thread.sleep(time);						
			xdg.setblock(0);						//�г�����xdg���Զ�����
			Thread.sleep(time);
			dg3.setclean(0);						//�г�����dg3
			Thread.sleep(time);
			adg.setblock(0);						//�г�����adg���Զ�����	
			Thread.sleep(time);
			dg1.setclean(0);						//�г�ռ��dg2
			Thread.sleep(time);
			dg3.setblock(0);dc3.setblock(0);dg1.setblock(0);dg1.setclean(0);		//�г�����dg3,dg3,dc3,dg2ͬʱ����,�г�����dg2
			return "�г��ɹ����ߵ���ɵ���";
		}
		else
			return "�����԰�����߽ӳ�";
	}
	}
