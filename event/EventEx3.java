package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import awt.MColor;


public class EventEx3 extends MFrame {//����Ŭ���� ��ư ����
	Button btn;
	
	public EventEx3() {
		add(btn = new Button("��ư"),BorderLayout.SOUTH);
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

