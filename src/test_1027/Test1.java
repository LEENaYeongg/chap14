package test_1027;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;


/*
���� ����� �������� ���α׷��� �ϼ��Ͻÿ�
[���]
�̸� ��� :ȫ�浿,���,�̸���,���ڹ�,���ڹ�,
���� ��� :10,30,15,25,20,
�ѳ����� �ջ� :100
������ ��� :20.0 
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
    static Person[] arr = {new Person("ȫ�浿",10),
            new Person("���",30),
            new Person("�̸���",15),
            new Person("���ڹ�",25),
            new Person("���ڹ�",20)};
	public static void main(String[] args) {
		System.out.print("�̸� ��� :");
        printString(s->s.name);
        System.out.print("���� ��� :");
        printInt(s->s.age);
        System.out.print("�ѳ����� �ջ� :");
        printTot(s->s.age);
        System.out.print("������ ��� :");
        printAvg(s->s.age);
}

static void printString(Function<Person,String> f) {
	for(Person s:arr)
        System.out.print(f.apply(s)+",");
     System.out.println();
}

static void printInt(ToIntFunction<Person> f) { //ToInt �Ű������� �ƴϰ� ����Ÿ���� Int�� �޾��ٰ�~
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
