package ch04;

public class Ex11 {
	public static void main(String[] args) {
		//1~10사이의 짝수를 출력하시오.
		for(int i=1;i<11;i++) {
			if(i%2==0)
				System.out.println(i+"\t");
		}//--for
		System.out.println("----------------------------");
		
		for(int i=1;i<11;i++) {
			if(i%2!=0)
				continue;
			System.out.println(i+"\t");
		}//--for
		
		//1~20사이에 3의 배수와 식과 합을 출력하시오.(continue)
		//3+6+9+12
		int sum=0;
		int j=0;
		for(int i=1;i<21;i++) {	
			if(i%3!=0)
				continue;
			sum+=i;
			System.out.print(i);
			
			if(i%3==0 && j<5) {
				j++;
				System.out.print("+");
			}	
		}
		System.out.println("="+sum);
	}		
}
