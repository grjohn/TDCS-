package com.model;

public class 进站信号机 {
	private String 信号机颜色; //信号机灯光
	private int 防护区段空闲;	//防护区段是否占用
	private int 下一区段空闲;	//下一个区段是否占用
	
	public 进站信号机(){												//初始化
		信号机颜色="红";
		防护区段空闲=1;//不占用
		下一区段空闲=1;//不占用
	}
	
	public void setcolor(String 信号机颜色){							//////////数据查询修改
		this.信号机颜色=信号机颜色;
	}
	public String getcolor(){
		return 信号机颜色;
	}
	
	public void setthisclean(int 防护区段空闲){
		this.防护区段空闲=防护区段空闲;
	}
	public int getthisclean(){
		return 防护区段空闲;
	}
	
	public void setnextclean(int 下一区段空闲){
		this.下一区段空闲=下一区段空闲;
	}
	public int getnextclean(){
		return 下一区段空闲;
	}																///////////

}
