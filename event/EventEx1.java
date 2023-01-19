package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import awt.MColor;

/* 2. 버튼을 클릭하면 ActionEvent 이벤트 객체가 발생되어서 
 * 이벤트 소스랑 ActionEvent 객체를 연결하기 위한 
 * ActionoListener 를 구현한다. */
public class EventEx1 extends MFrame implements ActionListener
/* 이벤트 리스너"*/{
	//1. 이벤트 소스를 생성
	Button btn;
		
	public EventEx1() {
		add(btn = new Button("버튼"),BorderLayout.SOUTH);
		//4. 이벤트소스랑 이벤트 핸들러 연결(addXxxListener)
		btn.addActionListener(this);
		validate();
	}
	
	//3. 이벤트리스너의 메소드(이벤트 핸들러) 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(MColor.rColor());
	}
	
	public static void main(String[] args) {
		new EventEx1();
	}
}
