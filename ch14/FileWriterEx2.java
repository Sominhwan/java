package ch14;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import ch12.RunnableEx1;

public class FileWriterEx2 extends MFrame implements ActionListener, Runnable {
	String txt;
	TextArea ta;
	TextField tf;
	Button save;

	public FileWriterEx2() {
		super(300, 400);
		setTitle("FileWriterEx1");
		add(ta = new TextArea());
		Panel p = new Panel();
		p.add(tf = new TextField(25));
		p.add(save = new Button("SAVE"));
		ta.setEditable(false);
		tf.addActionListener(this);
		save.addActionListener(this);
		add(p, BorderLayout.SOUTH);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tf) {
			ta.append(tf.getText() + "\n");
			tf.setText("");
			tf.requestFocus();
		} else if (obj == save) {
			txt = ta.getText();
			tf.setText("");

			run();
			saveFile(txt);
		}
	}

	@Override
	public void run() {
		ta.setText("");
		for (int i = 5; i > 0; i--) {
			try {
				ta.append(Integer.toString(i));
				Thread.sleep(1000);// 0.2초
				ta.setText("");

			} catch (Exception e) {

			}
		}
		ta.append("끝! 저장");
	}

	public void saveFile(String intxt) {
		try {
			long fName = System.currentTimeMillis();
			FileWriter fw = new FileWriter("ch14/" + fName + ".txt");
			fw.write(intxt);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileWriterEx2();
	}
}
