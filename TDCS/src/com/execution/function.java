package com.execution;
import com.blocklist.*;
import javax.swing.*;
import java.awt.*;
public class function {
	public static void main(String[] args) throws InterruptedException {

		������ l1=new ������();

		JFrame j=new JFrame("������վվ��ͼ(�ֲ�)");
		j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);
		j.setSize(900, 900);
		j.setVisible(true);
		JPanel states = new JPanel();
		states.setBackground(new Color(240, 240, 240));
		j.getContentPane().add(states, BorderLayout.NORTH);
		states.setLayout(new BorderLayout(0, 0));
		
		JTextArea textstates = new JTextArea(6,30);
		textstates.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		textstates.setLineWrap(true);
		states.add(textstates);
		textstates.setText(l1.zhengxianjiecheX_S2()+"\r\n");
		textstates.append(l1.cexianjiecheX_S1());
		
		JPanel changzhantu = new JPanel();
		j.getContentPane().add(changzhantu, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		j.getContentPane().add(panel_2, BorderLayout.SOUTH);

	}
		
		//j.drawRect(80,100,40,25);//���߿� g.setColor(Color.yellow);g.fillRect(20,70,20,30);//����ɫ��
}
