package ch04;

import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		//입력한 1~20 사이의 숫자중에 3,6,9 인지를 판단하세요.
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt();
		
		int b=a%10;
		if(b!=0 && b%3==0) 
			
			System.out.println("짝");
		else
			System.out.println(a);
		
		
	}
}
