package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import awt.MColor;


public class EventEx3 extends MFrame {//내부클래스 버튼 선언
	Button btn;
	
	public EventEx3() {
		add(btn = new Button("버튼"),BorderLayout.SOUTH);
		MyAction ma = new MyAction();
		btn.addActionListener(ma);
	}
	
	class MyAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setBackground(MColor.rColor());
			btn.setBackground(MColor.rColor());
		}
	}

	public static void main(String[] args) {
		new EventEx3();
	}
}

