package com.model;
import java.awt.Color;
public class �ɵ� {
	private int ����;
	private int ����;
	private Color ��ɫ;
	
	public �ɵ�(){
		����=1;
		����=0;
		��ɫ=Color.black;
	}
	
	public void setcolor(Color ��ɫ){							//////////���ݲ�ѯ�޸�
		this.��ɫ=��ɫ;
	}
	public Color getcolor(){
		return ��ɫ;
	}
	
	public void setclean(int ����){
		this.����=����;
		if(����==1)
		{
			��ɫ=Color.black;
		}
		else
		{
			��ɫ=Color.red;
		}
	}
	public int getclean(){
		return ����;
	}
	
	public void setblock(int ����){
		this.����=����;
		if(����==1)
		{
			if(����==1)��ɫ=Color.white;
		}
		else
		{
			��ɫ=Color.black;
			this.setclean(1);
		}
	}
	public int getblock(){
		return ����;
	}																///////////
}
