package ch08;


public class interfaceEx6 implements Runnable{
	String name;
	
	public interfaceEx6(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i+ " " + name);
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
			
		}
	}
	public static void main(String[] args) {
		interfaceEx6 a= new interfaceEx6("첫번째");
		interfaceEx6 b= new interfaceEx6("두번째");
		new Thread(a).start();//결론적으로 run 메소드 호출
		new Thread(b).start();
	}
}
