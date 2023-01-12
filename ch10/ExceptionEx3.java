package ch10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx3 {
	public static void main(String[] args) {
		Scanner s = null;
		try {
			int a, b;
			s = new Scanner(System.in);
			System.out.print("첫번째 숫자 : ");
			a = s.nextInt();
			System.out.print("두번째 숫지 : ");
			b = s.nextInt();
			System.out.println(a + "/" + b + "=" + (a / b));
			// 다중 catch 일 때는 하위 Exception 이 위에 옴.
			// }catch(Exception e){
		} catch (ArithmeticException e) {
			System.out.println("0으로 입력하면 안돼요.");
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력을 해야 합니다.");
		} finally {
			s.close();
		}

	}
}
