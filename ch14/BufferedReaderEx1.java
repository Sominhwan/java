package ch14;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderEx1 {
	public static void main(String[] args) {
//		InputStream is = System.in;
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader bw = new BufferedReader(isr);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		
		while(true) {
			try {
				s = br.readLine();
				System.out.println("출력 : "+s);
			} catch (Exception e) {
			
			}
		}
	}
}