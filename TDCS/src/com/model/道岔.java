package com.model;

public class ���� {
	private int ����;
	private int ��λ;
	
	public ����(){
		����=0;
		��λ=1;
	}
	
	public void setblock(int ����){
		this.����=����;
	}
	public int getblock(){
		return ����;
	}
	
	public void setdaily(int ��λ){
		if(����==0)
		this.��λ=��λ;
	}
	public int getdaily(){
		return ��λ;
	}
}
