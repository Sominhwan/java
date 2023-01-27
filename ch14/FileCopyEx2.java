package ch14;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyEx2 extends MFrame implements ActionListener {
	Button open, save;
	TextArea ta;
	FileDialog openDialog, saveDialog;
	String sourceDir;
	String sourceFile;

	public FileCopyEx2() {
		super(400, 500);
		setTitle("FileCopyEx2");
		add(ta = new TextArea());
		Panel p = new Panel();

		saveDialog = new FileDialog(this, "파일 저장", FileDialog.SAVE);
		p.add(open = new Button("OPEN"));
		p.add(save = new Button("SAVE"));
		ta.setEditable(false);
		open.addActionListener(this);
		save.addActionListener(this);
		add(p, BorderLayout.SOUTH);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		BufferedReader br;
		FileReader fr;

		if (obj == open) {
			openDialog = new FileDialog(this, "파일 열기", FileDialog.LOAD);
			openDialog.setVisible(true);
			sourceDir = openDialog.getDirectory();
			sourceFile = openDialog.getFile();
			try {
				fileReader(sourceDir + sourceFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (obj == save) {
			saveDialog = new FileDialog(this, "파일 저장", FileDialog.SAVE);
			saveDialog.setVisible(true);

			String sourceDir, sourceFile;

			sourceDir = saveDialog.getDirectory();
			sourceFile = saveDialog.getFile();
			fileWriter(sourceDir + sourceFile);
		}
	}

	// 선택된 파일의 내용이 ta에 append 해야함
	public void fileReader(String file) throws IOException {
		try {
			FileReader fr = new FileReader(file);
			int a;
			String s = "";
			while ((a = fr.read()) != -1) {
				s += (char) a;
			}
			ta.setText(s);
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ta에 오픈된 텍스트를 지정한 파일로 저장 해야함
	public void fileWriter(String file) {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(ta.getText());
			for (int i = 5; i > 0; i--) {
				ta.setText("저장 되었습니다." + i + "초후에 사라집니다.");
				Thread.sleep(1000);
			}
			ta.setText("");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		new FileCopyEx2();
	}
}
