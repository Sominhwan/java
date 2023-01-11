package ch06;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ThisEx3 extends MFrame
implements ActionListener{
	Button btn;
	
	public ThisEx3() {
		super(500,350,Color.green,true);
		btn=new Button("my Button");
		add(btn,"South");
		btn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		//System.out.println("보이나요?");
		MDialog md=new MDialog(this, "보이나요");
	}
	
	class MDialog extends Dialog 
	implements ActionListener{
		Random r1,r2;
		Button mbtn;
		ThisEx3 f;
		public MDialog(ThisEx3 f,String title) {
			super(f,title,true);
			this.f=f;
			setLayout(new FlowLayout());
			setSize(150,100);
			mbtn=new Button("Click!");
			mbtn.addActionListener(this);
			add(mbtn);
			setVisible(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			r1=new Random();
			r2=new Random();
			int rr1 = r1.nextInt(256);
			int gg1 = r1.nextInt(256);
			int bb1 = r1.nextInt(256);
			int rr2 = r1.nextInt(256);
			int gg2 = r1.nextInt(256);
			int bb2 = r1.nextInt(256);
			f.setBackground(new Color(rr2,gg2,bb2));
			f.btn.setBackground(new Color(rr1,gg1,bb1));
			dispose();			
		}		
	}
	
	public static void main(String[] args) {
		new ThisEx3();
	}
}
