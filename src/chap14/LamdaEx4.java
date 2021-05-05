package chap14;

/* 매개변수도 있고, 리턴값도 있는 경우 */
interface LambdaInterface4 {
	int method(int x, int y);
}

public class LamdaEx4 {
	public static void main(String[] args) {
		LambdaInterface4 f = (x, y) -> {
			return x * y;
		};
		System.out.println("두 수의 곱:" + f.method(2, 5));
		f=(x,y)->x+y;
		System.out.println("두 수의 합:" + f.method(2, 5));
		f=(x,y)->x-y;
		System.out.println("두 수의 차:" + f.method(2, 5));
		f=(x,y)->x%y;
		System.out.println("두 수를 나눈 나머지:" + f.method(2, 5));
		f=(x,y)->(x>y)?x:y;
		System.out.println("두 수 중 큰수:" + f.method(2, 5));
		f=(x,y)->(x<y)?x:y;
		System.out.println("두 수 중 작은수:" + f.method(2, 5));
	}
	private static int sum(int x, int y) {
		return x+y;
	}
}
