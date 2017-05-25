package com.model;
import java.awt.Color;
public class 股道 {
	private int 空闲;
	private int 锁闭;
	private Color 颜色;
	
	public 股道(){
		空闲=1;
		锁闭=0;
		颜色=Color.black;
	}
	
	public void setcolor(Color 颜色){							//////////数据查询修改
		this.颜色=颜色;
	}
	public Color getcolor(){
		return 颜色;
	}
	
	public void setclean(int 空闲){
		this.空闲=空闲;
		if(空闲==1)
		{
			颜色=Color.black;
		}
		else
		{
			颜色=Color.red;
		}
	}
	public int getclean(){
		return 空闲;
	}
	
	public void setblock(int 锁闭){
		this.锁闭=锁闭;
		if(锁闭==1)
		{
			if(空闲==1)颜色=Color.white;
		}
		else
		{
			颜色=Color.black;
			this.setclean(1);
		}
	}
	public int getblock(){
		return 锁闭;
	}																///////////
}
