package chap14;

/* 람다식 예제 : jdk8.0 이후부터 사용가능.
 * 		람다식에서 사용되는 인터페이스는 FunctionalInterface 여야함.
 * FunctionalInterface : 추상메서드가 한개만 존재하는 메서드 
 * 
 * 추상메서드의 매개변수가 없고, 리턴타입도 없는 경우
 * ()->{.....}
 * 람다식 내부에 실행되는 구문이 한개인 경우 {} 생략 가능함.*/
@FunctionalInterface
interface LambdaInterface1 {
	void method();
}

public class LamdaEx1 {
	public static void main(String[] args) {
		//익명의 내부클래스의 객체.
		LambdaInterface1 fi = new LambdaInterface1() {
			@Override
			public void method() {
				System.out.println("기존 방식으로 코딩");
			}
		};
		fi.method();
		//람다방식으로 코딩
		fi = ()-> {
			String str = "람다 방식으로 코딩1";
			System.out.println(str);
		};
		fi.method();
		fi = ()-> {
			System.out.println("람다 방식으로 코딩2");
		};
		fi.method();
		fi=()->System.out.println("람다 방식으로 코딩3");
		fi.method();
		execute(()->System.out.println("람다 방식으로 코딩4"));
	}
	static void execute(LambdaInterface1 f) { //매개변수로도 람다방식 적용 가능.
		f.method();
	}

}
