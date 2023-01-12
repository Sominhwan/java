package ch08;

interface Interface2{
	int a=10;//필드는 무조건 상수 static final
	//void prn() {}//일반 메소드는 선언 불가
	void prn();
}

//인터페이스들끼리 상속 가능 
interface Interface2_1 extends Interface2 {
	void prn1();
}

class MyClass3 implements Interface2_1{
	@Override
	public void prn() {
	}
	
	@Override
	public void prn1() {
	}
}

public class interfaceEx2 {
	
}
