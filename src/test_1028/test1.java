package test_1028;

import java.util.function.BinaryOperator;

/* 1. 다음의 결과가 나오도록 main 메서드를 완성하시오

[결과]
영어최고점 학생=>[name=임꺽정,eng=90,math=95,총점:185]
영어최저점 학생=>[name=홍길동,eng=75,math=80,총점:155]
수학최고점 학생=>[name=임꺽정,eng=90,math=95,총점:185]
수학최저점 학생=>[name=이몽룡,eng=80,math=70,총점:150]
합계최고점 학생=>[name=임꺽정,eng=90,math=95,총점:185]
합계최저점 학생=>[name=이몽룡,eng=80,math=70,총점:150]
 * */
class Student {
	private String name;
	private int eng;
	private int math;

	public Student(String name, int eng, int math) {
		this.name = name;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	@Override
	public String toString() {
		return "[name=" + name + ",eng=" + eng + ",math=" + math + ",총점:" + (eng + math) + "]";
	}
}

public class test1 {
	private static Student[] list = { new Student("홍길동", 75, 80), new Student("김삿갓", 85, 85),
			new Student("이몽룡", 80, 70), new Student("임꺽정", 90, 95) };

public static void main(String[] args) {
	  System.out.println("영어최고점 학생=>"+ getMaxOrMin((a, b) -> (a.getEng() >= b.getEng()) ? a : b));
      System.out.println("영어최저점 학생=>"+ getMaxOrMin((a, b) -> (a.getEng() <= b.getEng()) ? a : b));
      System.out.println("수학최고점 학생=>"+ getMaxOrMin((a, b) -> (a.getMath() >= b.getMath()) ? a : b));
      System.out.println("수학최저점 학생=>"+ getMaxOrMin((a, b) -> (a.getMath() <= b.getMath()) ? a : b));
      System.out.println("합계최고점 학생=>"+ getMaxOrMin((a, b) -> (a.getEng()+a.getMath() >= b.getEng()+b.getMath()) ? a : b));
      System.out.println("합계최저점 학생=>"+ getMaxOrMin((a, b) -> (a.getEng()+a.getMath() <= b.getEng()+b.getMath()) ? a : b));
 }

	private static Student getMaxOrMin(BinaryOperator<Student> f) {
		Student result = list[0];
		for (Student s : list) {
			result = f.apply(result, s);
		}
		return result;
	}
}