package com.model;

public class �ɵ� {
	private int ����;
	private int ����;
	private String ��ɫ;
	
	public �ɵ�(){
		����=1;
		����=0;
		��ɫ="��";
	}
	
	public void setcolor(String ��ɫ){							//////////���ݲ�ѯ�޸�
		this.��ɫ=��ɫ;
	}
	public String getcolor(){
		return ��ɫ;
	}
	
	public void setclean(int ����){
		this.����=����;
		if(����==1)
		{
			��ɫ="��";
		}
		else
		{
			��ɫ="��";
		}
	}
	public int getclean(){
		return ����;
	}
	
	public void setblock(int ����){
		this.����=����;
		if(����==1)
		{
			��ɫ="��";
		}
		else
		{
			��ɫ="��";
			����=1;
		}
	}
	public int getblock(){
		return ����;
	}																///////////
}
