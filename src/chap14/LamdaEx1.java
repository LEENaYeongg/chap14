package chap14;

/* ���ٽ� ���� : jdk8.0 ���ĺ��� ��밡��.
 * 		���ٽĿ��� ���Ǵ� �������̽��� FunctionalInterface ������.
 * FunctionalInterface : �߻�޼��尡 �Ѱ��� �����ϴ� �޼��� 
 * 
 * �߻�޼����� �Ű������� ����, ����Ÿ�Ե� ���� ���
 * ()->{.....}
 * ���ٽ� ���ο� ����Ǵ� ������ �Ѱ��� ��� {} ���� ������.*/
@FunctionalInterface
interface LambdaInterface1 {
	void method();
}

public class LamdaEx1 {
	public static void main(String[] args) {
		//�͸��� ����Ŭ������ ��ü.
		LambdaInterface1 fi = new LambdaInterface1() {
			@Override
			public void method() {
				System.out.println("���� ������� �ڵ�");
			}
		};
		fi.method();
		//���ٹ������ �ڵ�
		fi = ()-> {
			String str = "���� ������� �ڵ�1";
			System.out.println(str);
		};
		fi.method();
		fi = ()-> {
			System.out.println("���� ������� �ڵ�2");
		};
		fi.method();
		fi=()->System.out.println("���� ������� �ڵ�3");
		fi.method();
		execute(()->System.out.println("���� ������� �ڵ�4"));
	}
	static void execute(LambdaInterface1 f) { //�Ű������ε� ���ٹ�� ���� ����.
		f.method();
	}

}
