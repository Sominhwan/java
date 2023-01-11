package ch06;


class SuperClass4{
	//super 라는 키워드 부모를 지칭하는 것.
	//super()는 반드시 첫번째 라인에 삽입(생략)
//	public SuperClass4() {
//	}
	
	public SuperClass4(int i) {
		//super();
		System.out.println("오류");
	}
}

class SubClass4 extends SuperClass4{
	public SubClass4() {
		super(22);//생략: 반드시 생성자의 첫번째 라인
		System.out.println("Sub 생성자");
	}
	
}

public class ConstructorEx4 {
	public static void main(String[] args) {
		SubClass4 s1=new SubClass4();
		
	}
}
