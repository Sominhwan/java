package talk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class TalkServer {

	Vector<TalkThread> vc;
	ServerSocket server;
	int port = 8016;
	TalkMgr mgr;

	public TalkServer() {
		try {
			vc = new Vector<TalkThread>();
			server = new ServerSocket(port);
			mgr = new TalkMgr();
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("****************************************");
		System.out.println("*Welcome Chat Server 1.0...");
		System.out.println("*Ŭ���̾�Ʈ ������ ��ٸ��� �ֽ��ϴ�.");
		System.out.println("****************************************");
		try {
			while (true) {
				Socket sock = server.accept();
				TalkThread ct = new TalkThread(sock);
				ct.start();
				vc.addElement(ct);
			}
		} catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}

	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			TalkThread ct = vc.elementAt(i);
			ct.sendMessage(msg);
		}
	}

	public void removeClient(TalkThread ct) {
		vc.remove(ct);
	}

	// ���ӵ� ��� id ����Ʈ ���� ex) aaa;bbb;ccc;ddd;ȫ�浿;
	public String getIdList() {
		String ids = "";
		for (int i = 0; i < vc.size(); i++) {
			TalkThread ct = vc.get(i);
			ids += ct.id + ";";
		}
		return ids;
	}

	// �Ű����� id������ ClientThread3�� �˻�
	public TalkThread findClient(String id) {
		TalkThread ct = null;
		for (int i = 0; i < vc.size(); i++) {
			ct = vc.get(i);
			if (ct.id.equals(id)) {// �Ű����� id�� Client�� id�� ���ٸ�...
				break;
			}
		} // --for
		return ct;
	}// --findClient

	class TalkThread extends Thread {

		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "�͸�";

		public TalkThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter((sock.getOutputStream()), true);
				System.out.println(sock + " ���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
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
				removeClient(this);
				System.err.println(sock + "[" + id + "] ������...");
			}
		}

		public void routine(String line) {
			System.out.println("line:" + line);
			int idx = line.indexOf(TalkProtocol.MODE);
			String cmd = line.substring(0, idx);
			String data = line.substring(idx + 1);
			// ID:aaa;1234
			if (cmd.equals(TalkProtocol.ID)) {
				idx = data.indexOf(';');
				cmd = data.substring(0, idx);// aaa
				data = data.substring(idx + 1);// 1234
				if (mgr.loginChk(cmd, data)) {
					// �α��� ����
					TalkThread ct = findClient(cmd);
					if (ct != null && ct.id.equals(cmd)) {
						// ��������
						sendMessage(TalkProtocol.ID + TalkProtocol.MODE + "C");
					} else {
						id = cmd;
						sendMessage(TalkProtocol.ID + TalkProtocol.MODE + "T");
						sendAllMessage(TalkProtocol.CHATLIST + TalkProtocol.MODE + getIdList());
						sendAllMessage(TalkProtocol.CHATALL + TalkProtocol.MODE + "[" + id + "]���� �����Ͽ����ϴ�");
					}
				}
				} else if (cmd.equals(TalkProtocol.CHATALL)) {
					sendAllMessage(TalkProtocol.CHATALL + TalkProtocol.MODE + "[" + id + "]" + data);
				}
			}
		

		public void sendMessage(String msg) {
			out.println(msg);
		}
	}

	public static void main(String[] args) {
		new TalkServer();
	}
}
