package com.model;

public class ��վ�źŻ� {
	private String �źŻ���ɫ; //�źŻ��ƹ�
	private int �������ο���;	//���������Ƿ�ռ��
	private int ��һ���ο���;	//��һ�������Ƿ�ռ��
	
	public ��վ�źŻ�(){
		�źŻ���ɫ="��";
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
	
	public void setlastclean(int ��һ���ο���){
		this.��һ���ο���=��һ���ο���;
	}
	public int getlastclean(){
		return ��һ���ο���;
	}																////////////
	
	public String banlijinzhan(String ��վ����,int ����){					//��ѯ�Ƿ��ܹ������·
		if(�������ο���==1&&����==0) //�źŻ�ǰ�󶼲�ռ������·δ����
		{	
			if(��վ����=="���߽ӳ�")
				�źŻ���ɫ="����";
			else if(��վ����=="���߽ӳ�")
				�źŻ���ɫ="˫��";
			return "���԰����·";
		}
		else
		return "���ܰ����·";		
	}
	
	
	
}
