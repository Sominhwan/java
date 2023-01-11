package ch06;

class Method3{
	void prin(int...arr/*배열로 인식*/) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
}
public class MethodEx3 {
	public static void main(String[] args) {
		Method3 mt=new Method3();
		mt.prin(1);
		mt.prin(1, 2);
		mt.prin(1, 2, 3);
		mt.prin(1, 2, 3, 4);
		mt.prin(1, 4, 5, 6, 7, 8, 9, 10);
		System.out.printf("%s","하하");
	}
}
