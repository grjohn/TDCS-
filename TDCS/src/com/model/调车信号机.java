package com.model;

public class �����źŻ� {
	private String �źŻ���ɫ; //�źŻ��ƹ�
	private int �������ο���;	//���������Ƿ�ռ��
	private int ��һ���ο���;	//��һ�������Ƿ�ռ��
	
	public �����źŻ�(){												//��ʼ��
		�źŻ���ɫ="��ɫ";
		�������ο���=1;//��ռ��
		��һ���ο���=1;//��ռ��
	}
	
	public void setcolor(String �źŻ���ɫ){							//////////���ݲ�ѯ�޸�
		this.�źŻ���ɫ=�źŻ���ɫ;
	}
	public String getcolor(){
		return �źŻ���ɫ;
	}
	
	public void setthisclean(int �������ο���){
		this.�������ο���=�������ο���;
	}
	public int getthisclean(){
		return �������ο���;
	}
	
	public void setnextclean(int ��һ���ο���){
		this.��һ���ο���=��һ���ο���;
	}
	public int getnextclean(){
		return ��һ���ο���;
	}																///////////
	
}
