package com.model;
import java.awt.Color;
public class ��վ������źŻ� {
	private Color �źŻ���ɫ; //�źŻ��ƹ�
	private int �������ο���;	//���������Ƿ�ռ��
	private int ��һ���ο���;	//��һ�������Ƿ�ռ��
	
	public ��վ������źŻ�(){
		�źŻ���ɫ=Color.red;
		�������ο���=1;//��ռ��
		��һ���ο���=1;//��ռ��
	}
	
	public void setcolor(Color �źŻ���ɫ){							//////////���ݲ�ѯ�޸�
		this.�źŻ���ɫ=�źŻ���ɫ;
	}
	public Color getcolor(){
		return �źŻ���ɫ;
	}
	
	public void setthisclean(int �������ο���){
		this.�������ο���=�������ο���;
	}
	public int getthisclean(){
		return �������ο���;
	}
	
	public void setlastclean(int ��һ���ο���){
		this.��һ���ο���=��һ���ο���;
	}
	public int getlastclean(){
		return ��һ���ο���;
	}																////////////	
}
