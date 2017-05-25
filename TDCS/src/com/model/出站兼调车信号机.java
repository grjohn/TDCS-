package com.model;
import java.awt.Color;
public class 出站兼调车信号机 {
	private Color 信号机颜色; //信号机灯光
	private int 防护区段空闲;	//防护区段是否占用
	private int 上一区段空闲;	//下一个区段是否占用
	
	public 出站兼调车信号机(){
		信号机颜色=Color.red;
		防护区段空闲=1;//不占用
		上一区段空闲=1;//不占用
	}
	
	public void setcolor(Color 信号机颜色){							//////////数据查询修改
		this.信号机颜色=信号机颜色;
	}
	public Color getcolor(){
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
}
