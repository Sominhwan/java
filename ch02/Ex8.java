package ch02;

import java.io.IOException;

public class Ex8 {
	public static void main(String[] args) throws IOException {
		System.out.println("키보드를 입력하고 Enter 하세요.");
		while(true) {
		int keyCode=System.in.read();
		
		if(keyCode=='q')
			break;
		
		System.out.println("keyCode: "+keyCode);
		}//--while
		System.out.println("종료~");
	}

}
