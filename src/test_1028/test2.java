package test_1028;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/*2. IntBinaryOperator 인터페이스와 IntPredicate 인터페이스를 이용하여배열에 저장된 짝수,홀수별 최대 숫자와 최소 숫자를 출력하는 프로그램 완성하기
[결과]
26,17,64,41,100,37,84,66,84,92,
홀수 최대값:41
짝수 최대값:100
홀수최소값:17
짝수최소값:26
*/
public class test2 {
	private static int[] arr = new int[10];

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
			System.out.print(arr[i] + ",");
		}

		System.out.println();
		System.out.println("홀수 최대값:" + maxOrMin((a, b) -> (a >= b) ? a : b, a -> a % 2 != 0));
		System.out.println("짝수 최대값:" + maxOrMin((a, b) -> (a >= b) ? a : b, a -> a % 2 == 0));
		System.out.println("홀수최소값:" + maxOrMin((a, b) -> (a <= b) ? a : b, a -> a % 2 != 0));
		System.out.println("짝수최소값:" + maxOrMin((a, b) -> (a <= b) ? a : b, a -> a % 2 == 0));
		System.out.println("최대값:" + maxOrMin((a, b) -> (a >= b) ? a : b, a ->true));
		System.out.println("최소값:" + maxOrMin((a, b) -> (a <= b) ? a : b, a -> true));
	}

	private static int maxOrMin(IntBinaryOperator op, IntPredicate p) { // 자료형 int
		int result = 0;
		for (int a : arr) {
			if (p.test(a)) // 짝수 또는 홀수
				if (result == 0)
					result = a; // 첫번째 홀수
				else
					result = op.applyAsInt(result, a);
		}
		return result;
	}
}
