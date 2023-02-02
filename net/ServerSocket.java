package net;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import net.ChatServer1.ClientThread1;

public class ServerSocket {
	public ServerSocket() {
		try {
			server = new ServerSocket(PORT);
			vc= new Vector<ClientThread1>();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error in Server");
			System.exit(1);// ���������� ����
		}
		System.out.println("****************************");
		System.out.println("ChatServer1 v1.0 ���۵Ǿ����ϴ�.");
		System.out.println("****************************");
		try {
			Socket sock = server.accept();
			ClientThread1 ct =new ClientThread1(sock);
			ct.start();
			// ������ Ŭ���̾�Ʈ Socket ��ü�� Bector ����
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error in Socket");
		}
	}
	
	public static void main(String[] args) {
		new ServerSocket();
	}
}
