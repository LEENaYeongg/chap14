package chap14;

/* �Ű������� �ְ�, ���ϰ��� �ִ� ��� */
interface LambdaInterface4 {
	int method(int x, int y);
}

public class LamdaEx4 {
	public static void main(String[] args) {
		LambdaInterface4 f = (x, y) -> {
			return x * y;
		};
		System.out.println("�� ���� ��:" + f.method(2, 5));
		f=(x,y)->x+y;
		System.out.println("�� ���� ��:" + f.method(2, 5));
		f=(x,y)->x-y;
		System.out.println("�� ���� ��:" + f.method(2, 5));
		f=(x,y)->x%y;
		System.out.println("�� ���� ���� ������:" + f.method(2, 5));
		f=(x,y)->(x>y)?x:y;
		System.out.println("�� �� �� ū��:" + f.method(2, 5));
		f=(x,y)->(x<y)?x:y;
		System.out.println("�� �� �� ������:" + f.method(2, 5));
	}
	private static int sum(int x, int y) {
		return x+y;
	}
}
