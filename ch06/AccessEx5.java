package ch06;

import java.awt.Frame;

//java.awt.Frame에서 paramString 의 결과값을 출력
public class AccessEx5 extends Frame {
	public AccessEx5(){
		System.out.println(paramString());
	}
	public static void main(String[] args) {
		AccessEx5 ac=new AccessEx5();
	}

}
