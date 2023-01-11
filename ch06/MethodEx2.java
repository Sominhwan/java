package ch06;

class Method2{
	/*메소드 오버로딩(Over loading) : 기능은 동일함.
	 * 동일한 메소드명으로 매개변수의 개수와 타입을 다르게 선언, 
	 */
	void prn(int a) {
		System.out.println(a);
	}
	void prn(int a, int  b) {
		System.out.println(a+"\t"+b);
	}
	void prn(int a, int b, int c) {
		System.out.println(a+"\t"+b+"\t"+c);
	}
	void prn(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+"\t");		
		}
	}	
}
public class MethodEx2 {
	public static void main(String[] args) {
		//Math 클래스에 abs 메소드는 절대값 리턴
		int a = Math.abs(-10);
		double d=Math.abs(3.14);
		Math.abs(a);
		Method2 mt=new Method2();
		mt.prn(10);
		mt.prn(10, 20);
		mt.prn(10, 20, 30);
	}
}
