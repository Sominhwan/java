package ch09;
/*내부(중첩)클래스
 * 1.클래스 안에 선언
 * 2.클래스안에 선언이지만 static 클래스 선언(활용도: 1%)
 * 3.메소드안에 클래스 선언(활용도 : 10%)
 * 4.메소드 안에 선언을 하고 선언과 동시에 생성하는 익명클래스(활용도 : 100%)
 */

interface MyInter{
	void prn();
}

class Outer1{
	class Inner1{
		
	}
	
	static class Inner2{
		
	}
	
	//메소드안에 메소드는 선언 불가
	void prn() {
		class Inner3{
			
		}
		
		new MyInter() {		
			@Override
			public void prn() {
			}
		};
	}
	
}//--class Inner1

public class InnerEx1 {
	public static void main(String[] args) {
		
	}
}
