package com.model;

public class 进站信号机 {
	private String 信号机颜色; //信号机灯光
	private int 防护区段空闲;	//防护区段是否占用
	private int 上一区段空闲;	//下一个区段是否占用
	
	public 进站信号机(){
		信号机颜色="红";
		防护区段空闲=1;//不占用
		上一区段空闲=1;//不占用
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
	
	public void setlastclean(int 上一区段空闲){
		this.上一区段空闲=上一区段空闲;
	}
	public int getlastclean(){
		return 上一区段空闲;
	}																////////////
	
	public String banlijinzhan(String 进站方法,int 锁闭){					//查询是否能够办理进路
		if(防护区段空闲==1&&锁闭==0) //信号机前后都不占用且线路未锁闭
		{	
			if(进站方法=="正线接车")
				信号机颜色="单黄";
			else if(进站方法=="侧线接车")
				信号机颜色="双黄";
			return "可以办理进路";
		}
		else
		return "不能办理进路";		
	}
	
	
	
}
