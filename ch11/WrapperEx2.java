package ch11;

import java.util.Scanner;

public class WrapperEx2 {
	public static void main(String[] args) {
		char c1 = 'J';
		System.out.println(c1);
		if(Character.isLetter(c1))
			System.out.println(" : 문자입니다.");
		
		char c2 = 'a';//대문자인지 소문자인지 판단
		if(Character.isUpperCase(c2) )
			System.out.println(" : 대문자.");
	
		char c3 = '2';
		if(Character.isDigit(c3))
			System.out.println(" : 숫자입니다.");
		
		char c4 = ' ';
		if(Character.isWhitespace(c4))
			System.out.println(" : 공백입니다.");
		
		Long l;
		Boolean b;
		Short s;
		Double d;
		Float f;
		Byte bt;
		Integer i;
		Character c;
		
		Scanner sc= new Scanner(System.in);
		sc.nextInt();
		System.out.println(sc);
		
	}
}
