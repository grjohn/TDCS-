package com.model;

public class 股道 {
	private int 空闲;
	private int 锁闭;
	private String 颜色;
	
	public 股道(){
		空闲=1;
		锁闭=0;
		颜色="灰色";
	}
	
	public void setcolor(String 颜色){							//////////数据查询修改
		this.颜色=颜色;
	}
	public String getcolor(){
		return 颜色;
	}
	
	public void setclean(int 空闲){
		this.空闲=空闲;
		if(空闲==1)
		{
			颜色="灰色";
		}
		else
		{
			颜色="红色";
		}
	}
	public int getclean(){
		return 空闲;
	}
	
	public void setblock(int 锁闭){
		this.锁闭=锁闭;
		if(锁闭==1)
		{
			颜色="白色";
		}
		else
		{
			颜色="灰色";
		}
	}
	public int getblock(){
		return 锁闭;
	}																///////////
}
