package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends MFrame implements ActionListener{
	Button btn;
	boolean flag = false;
	
	public MyFrame() {
		btn = new Button("Button");
		add(btn,BorderLayout.SOUTH);
		setBackground(Color.ORANGE);
		//actionPerformed 연결 메소드
		//내 자신이 addActionListener 타입이므로 this 가 가능
		//버튼을 클릭을 하면 ActionEvent 객체가 내부적으로 생성됨
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(flag)
			setBackground(Color.ORANGE);
		else
			setBackground(Color.PINK);
		flag=!flag;
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
