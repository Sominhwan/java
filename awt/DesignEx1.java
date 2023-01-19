package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesignEx1 extends MFrame2 implements ActionListener {
	
	Label label;
	Checkbox cb1, cb2, cb3;
	CheckboxGroup cbg;
	Button btn1, btn2;
	
	public DesignEx1() {
		super(250,150);
		setTitle("������ ����1");
		setLocationRelativeTo(null);
		String str = "�����߿� ����";
		Panel p1,p2,p3;
		
		p1 = new Panel();
		p1.setBackground(Color.GREEN);
		p1.add(label = new Label(str,Label.CENTER));
		add(p1,BorderLayout.NORTH);
		
		cbg= new CheckboxGroup();
		
		p2= new Panel();
		p2.add(cb1 = new Checkbox("���",cbg, false));
		p2.add(cb2 = new Checkbox("����",cbg, true));
		p2.add(cb3 = new Checkbox("�޵�",cbg, false));
		add(p2);
		
		p3= new Panel();
		p3.add(btn1 = new Button("Start"));
		p3.add(btn2 = new Button("End"));
		add(p3,BorderLayout.SOUTH);
		
		validate();
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public static void main(String[] args) {
		new DesignEx1();
	}
}

