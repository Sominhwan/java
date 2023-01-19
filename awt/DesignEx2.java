package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesignEx2 extends MFrame2 implements ActionListener{
	TextField tf;
	TextArea ta;
	Button btn1, btn2;
	Panel p1, p2;
	
	public DesignEx2() {
		super(500,400);
		setTitle("디자인 예제2");
		setLocationRelativeTo(null);
		
		p1 = new Panel();
		p1.add(tf = new TextField("Hello JUN!",20));
		add(p1,BorderLayout.NORTH);
		add(ta = new TextArea(10,50));
		ta.setEditable(true);
				
		p2 = new Panel();
		p2.add(btn1 = new Button("마우스 시험용"));
		p2.add(btn2 = new Button("종료"));
		add(p2,BorderLayout.SOUTH);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		validate();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn2) 
			setVisible(false);
	}
	
	public static void main(String[] args) {
		new DesignEx2();
	}
}

