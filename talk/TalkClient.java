package talk;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.ChatProtocol;

public class TalkClient extends JFrame implements ActionListener, Runnable {

	JButton btn1, btn2;
	JTextField tf1, tf2;
	TextArea ta;
	JPanel p1, p2;
	BufferedReader in;
	PrintWriter out;
	String id;
	String title = "Talk Chat 3.0";
	String listTitle = "*****CHAT LIST*****";
	String label[] = { "MLIST", "MESSAGE", "SEND", "SAVE" };
	boolean flag = false;
	public static final int PORT = 8016;
	List talkList;
	TalkAWT talkAWT;

	public TalkClient(BufferedReader in, PrintWriter out, String id) {
		this.id = id;
		this.in = in;
		this.out = out;
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Talk 1.0 " + id + "님 반갑습니다.");
		p1 = new JPanel();
		p1.setBackground(new Color(200, 100, 200));
//		p1.add(new Label("HOST ",Label.CENTER));
//		p1.add(tf1 = new JTextField("127.0.0.1",15));
		p1.add(btn1 = new JButton("SAVE"));

		p2 = new JPanel();
		p2.setBackground(new Color(200, 100, 200));
		p2.add(new Label("CHAT ", Label.CENTER));
		p2.add(tf2 = new JTextField("", 15));
		p2.add(btn2 = new JButton("SEND"));
		talkList = new List();
		talkList.add(listTitle);
		// tf1.addActionListener(this);
		tf2.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);

		add(p1, BorderLayout.NORTH);
		add(ta = new TextArea());
		add(p2, BorderLayout.SOUTH);
		setVisible(true);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tf1 || obj == btn1/* save */) {
//			tf1.setEnabled(false);
//			btn1.setEnabled(false);
			String content = ta.getText();
			String fileName = "TalkFile";
			try {
				FileWriter fw = new FileWriter("talk/" + fileName + ".txt");
				fw.write(content);
				fw.close();
				ta.setText("");
				new MDialog(this, "Save", "대화내용을 저장하였습니다.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			tf2.requestFocus();
		}
		if (obj == tf2 || obj == btn2/* send */) {
			String str = tf2.getText().trim();
			if (filterMgr(str)) {
				new MDialog(this, "경고", "입력하신 글자는 금지어입니다.");
				return;
			}

			ta.append("[" + id + "]" + str + "\n");
			sendMessage(TalkProtocol.CHATALL + TalkProtocol.MODE + str);
			tf2.setText("");
			tf2.requestFocus();
			

		}

	} // --actionPerformed

	public void routine(String line) {
		int idx = line.indexOf(TalkProtocol.MODE);
		String cmd = line.substring(0, idx);
		String data = line.substring(idx + 1);
		if (cmd.equals(TalkProtocol.CHAT) || cmd.equals(TalkProtocol.CHATALL)) {
			ta.append(data + "\n");
		}
	}// --routine

	@Override // 서버로 부터 메세지가 들어오면 반응하는 기능
	public void run() {
		try {
			while (true) {
				String line = in.readLine();
				if (line == null)
					break;
				else
					routine(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// --run



	public void sendMessage(String msg) {
		out.println(msg);
	}

	public boolean filterMgr(String msg) {
		boolean flag = false;// false이면 금지어 아님
		String str[] = { "바보", "개새끼", "새끼", "자바", "java" };
		// msg : 하하 호호 히히
		StringTokenizer st = new StringTokenizer(msg);// 생략하면 구분자는 공백
		String msgs[] = new String[st.countTokens()];
		for (int i = 0; i < msgs.length; i++) {
			msgs[i] = st.nextToken();
		}
		for (int i = 0; i < str.length; i++) {
			if (flag)
				break;// 첫번째 for문 빠져나감.
			for (int j = 0; j < msgs.length; j++) {
				if (str[i].equalsIgnoreCase(msgs[j])) {
					flag = true;
					break; // 두번째 for문 빠져나감.
				} // if
			} // for2
		} // for1
		return flag;
	}

	class Message extends Frame implements ActionListener {

		Button send, close;
		TextField name;
		TextArea ta;
		String mode;// to/from
		String id;

		public Message(String mode) {
			setTitle("쪽지보내기");
			this.mode = mode;
			id = talkList.getSelectedItem();
			layset("");
			validate();
		}

		public Message(String mode, String id, String msg) {
			setTitle("쪽지읽기");
			this.mode = mode;
			this.id = id;
			layset(msg);
			validate();
		}

		public void layset(String msg) {
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			Panel p1 = new Panel();
			p1.add(new Label(mode, Label.CENTER));
			name = new TextField(id, 20);
			p1.add(name);
			add(BorderLayout.NORTH, p1);

			ta = new TextArea("");
			add(BorderLayout.CENTER, ta);
			ta.setText(msg);
			Panel p2 = new Panel();
			if (mode.equals("TO")) {
				p2.add(send = new Button("send"));
				send.addActionListener(this);
			}
			p2.add(close = new Button("close"));
			close.addActionListener(this);
			add(BorderLayout.SOUTH, p2);

			setBounds(200, 200, 250, 250);
			setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == send) {
				sendMessage(ChatProtocol.MESSAGE + ":" + id + ";" + ta.getText());
			}
			setVisible(false);
			dispose();
		}
	}

	class MDialog extends Dialog implements ActionListener {

		Button ok;
		TalkClient tk;

		public MDialog(TalkClient tk, String title, String msg) {
			super(tk, title, true);
			this.tk = tk;
			//////////////////////////////////////////////////////////////////////////////////////////
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			/////////////////////////////////////////////////////////////////////////////////////////
			setLayout(new GridLayout(2, 1));
			Label label = new Label(msg, Label.CENTER);
			add(label);
			add(ok = new Button("확인"));
			ok.addActionListener(this);
			layset();
			setVisible(true);
			validate();
		}

		public void layset() {
			int x = tk.getX();
			int y = tk.getY();
			int w = tk.getWidth();
			int h = tk.getHeight();
			int w1 = 150;
			int h1 = 100;
			setBounds(x + w / 2 - w1 / 2, y + h / 2 - h1 / 2, 200, 100);
		}

		public void actionPerformed(ActionEvent e) {
			tf2.setText("");
			dispose();
		}
	}
}
//	public static void main(String[] args) {
//		new TalkClient();
//	}

