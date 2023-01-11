package ch06;

//클래스 선언:ch06.Car1
//클래스: 객체를 만드는 틀(ex-붕어빵 틀)
class Car3/*클래스명*/{
	//필드 : 객체의 속성 <- 무조건 () 는 없다.
	String carName;
	int velocity;
	String carColor;
	
	//메소드 : 객체의 기능 <- 반드시 () 가 있다.
	void speedUp() {
		velocity++;
	}
	
	void speedDown() {
		velocity--;
		if(velocity<0)
			velocity=0;
	}
	
	void stop() {
		velocity=0;
	}
	

}//--class

//.java로 선언된 클래스만 public 사용가능
public class CarEx3 {
	public static void main(String[] args) {
		Car3 c1=new Car3();
		Car3 c2=new Car3();
		c1.carName="아반테";
		c2.carName="소나타";
		System.out.println(c1.carName);
		System.out.println(c2.carName);
		
		//System.out.println(c1.toString());
		//System.out.println(c2.toString());
		c2=c1;//참조형의 "=" 은 call by reference 방식
		//System.out.println(c1.toString());
		//System.out.println(c2.toString());
		System.out.println(c1.carName);
		System.out.println(c2.carName);
		c1.carName="그랜져";
		
		int a=10;
		int b=a;//자바 기본형: call by value 방식
		a=20;
		System.out.println(a+b);
	}
}
