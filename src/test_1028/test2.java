package test_1028;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/*2. IntBinaryOperator �������̽��� IntPredicate �������̽��� �̿��Ͽ��迭�� ����� ¦��,Ȧ���� �ִ� ���ڿ� �ּ� ���ڸ� ����ϴ� ���α׷� �ϼ��ϱ�
[���]
26,17,64,41,100,37,84,66,84,92,
Ȧ�� �ִ밪:41
¦�� �ִ밪:100
Ȧ���ּҰ�:17
¦���ּҰ�:26
*/
public class test2 {
	private static int[] arr = new int[10];

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
			System.out.print(arr[i] + ",");
		}

		System.out.println();
		System.out.println("Ȧ�� �ִ밪:" + maxOrMin((a, b) -> (a >= b) ? a : b, a -> a % 2 != 0));
		System.out.println("¦�� �ִ밪:" + maxOrMin((a, b) -> (a >= b) ? a : b, a -> a % 2 == 0));
		System.out.println("Ȧ���ּҰ�:" + maxOrMin((a, b) -> (a <= b) ? a : b, a -> a % 2 != 0));
		System.out.println("¦���ּҰ�:" + maxOrMin((a, b) -> (a <= b) ? a : b, a -> a % 2 == 0));
		System.out.println("�ִ밪:" + maxOrMin((a, b) -> (a >= b) ? a : b, a ->true));
		System.out.println("�ּҰ�:" + maxOrMin((a, b) -> (a <= b) ? a : b, a -> true));
	}

	private static int maxOrMin(IntBinaryOperator op, IntPredicate p) { // �ڷ��� int
		int result = 0;
		for (int a : arr) {
			if (p.test(a)) // ¦�� �Ǵ� Ȧ��
				if (result == 0)
					result = a; // ù��° Ȧ��
				else
					result = op.applyAsInt(result, a);
		}
		return result;
	}
}
