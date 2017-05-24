package com.model;

public class ¹ÉµÀ {
	private int ¿ÕÏĞ;
	private int Ëø±Õ;
	private String ÑÕÉ«;
	
	public ¹ÉµÀ(){
		¿ÕÏĞ=1;
		Ëø±Õ=0;
		ÑÕÉ«="»Ò";
	}
	
	public void setcolor(String ÑÕÉ«){							//////////Êı¾İ²éÑ¯ĞŞ¸Ä
		this.ÑÕÉ«=ÑÕÉ«;
	}
	public String getcolor(){
		return ÑÕÉ«;
	}
	
	public void setclean(int ¿ÕÏĞ){
		this.¿ÕÏĞ=¿ÕÏĞ;
		if(¿ÕÏĞ==1)
		{
			ÑÕÉ«="»Ò";
		}
		else
		{
			ÑÕÉ«="ºì";
		}
	}
	public int getclean(){
		return ¿ÕÏĞ;
	}
	
	public void setblock(int Ëø±Õ){
		this.Ëø±Õ=Ëø±Õ;
		if(Ëø±Õ==1)
		{
			ÑÕÉ«="°×";
		}
		else
		{
			ÑÕÉ«="»Ò";
			¿ÕÏĞ=1;
		}
	}
	public int getblock(){
		return Ëø±Õ;
	}																///////////
}
