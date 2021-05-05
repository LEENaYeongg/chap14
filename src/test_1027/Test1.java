package test_1027;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;


/*
다음 결과가 나오도록 프로그램을 완성하시오
[결과]
이름 목록 :홍길동,김삿갓,이몽룡,김자바,박자바,
나이 목록 :10,30,15,25,20,
총나이의 합산 :100
나이의 평균 :20.0 
*/
class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
           return name + ":" + age;
    }
}
public class Test1 {
    static Person[] arr = {new Person("홍길동",10),
            new Person("김삿갓",30),
            new Person("이몽룡",15),
            new Person("김자바",25),
            new Person("박자바",20)};
	public static void main(String[] args) {
		System.out.print("이름 목록 :");
        printString(s->s.name);
        System.out.print("나이 목록 :");
        printInt(s->s.age);
        System.out.print("총나이의 합산 :");
        printTot(s->s.age);
        System.out.print("나이의 평균 :");
        printAvg(s->s.age);
}

static void printString(Function<Person,String> f) {
	for(Person s:arr)
        System.out.print(f.apply(s)+",");
     System.out.println();
}

static void printInt(ToIntFunction<Person> f) { //ToInt 매개변수는 아니고 리턴타입을 Int로 받아줄게~
	for(Person s:arr)
        System.out.print(f.applyAsInt(s)+",");
     System.out.println();
}

static void printTot(ToIntFunction<Person> f) {
	int sum =0;
	for(Person s : arr) sum+=f.applyAsInt(s);
	System.out.println(sum);
}

static void printAvg(ToDoubleFunction<Person> f) {
	int sum =0;
	for(Person s : arr) sum+=f.applyAsDouble(s);
	System.out.println(sum/5);
	}
}
