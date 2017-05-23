package com.model;

public class 道岔 {
	private int 锁闭;
	private int 定位;
	
	public 道岔(){
		锁闭=0;
		定位=1;
	}
	
	public void setblock(int 锁闭){
		this.锁闭=锁闭;
	}
	public int getblock(){
		return 锁闭;
	}
	
	public void setdaily(int 定位){
		if(锁闭==0)
		this.定位=定位;
	}
	public int getdaily(){
		return 定位;
	}
}
