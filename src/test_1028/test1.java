package test_1028;

import java.util.function.BinaryOperator;

/* 1. ������ ����� �������� main �޼��带 �ϼ��Ͻÿ�

[���]
�����ְ��� �л�=>[name=�Ӳ���,eng=90,math=95,����:185]
���������� �л�=>[name=ȫ�浿,eng=75,math=80,����:155]
�����ְ��� �л�=>[name=�Ӳ���,eng=90,math=95,����:185]
���������� �л�=>[name=�̸���,eng=80,math=70,����:150]
�հ��ְ��� �л�=>[name=�Ӳ���,eng=90,math=95,����:185]
�հ������� �л�=>[name=�̸���,eng=80,math=70,����:150]
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
		return "[name=" + name + ",eng=" + eng + ",math=" + math + ",����:" + (eng + math) + "]";
	}
}

public class test1 {
	private static Student[] list = { new Student("ȫ�浿", 75, 80), new Student("���", 85, 85),
			new Student("�̸���", 80, 70), new Student("�Ӳ���", 90, 95) };

public static void main(String[] args) {
	  System.out.println("�����ְ��� �л�=>"+ getMaxOrMin((a, b) -> (a.getEng() >= b.getEng()) ? a : b));
      System.out.println("���������� �л�=>"+ getMaxOrMin((a, b) -> (a.getEng() <= b.getEng()) ? a : b));
      System.out.println("�����ְ��� �л�=>"+ getMaxOrMin((a, b) -> (a.getMath() >= b.getMath()) ? a : b));
      System.out.println("���������� �л�=>"+ getMaxOrMin((a, b) -> (a.getMath() <= b.getMath()) ? a : b));
      System.out.println("�հ��ְ��� �л�=>"+ getMaxOrMin((a, b) -> (a.getEng()+a.getMath() >= b.getEng()+b.getMath()) ? a : b));
      System.out.println("�հ������� �л�=>"+ getMaxOrMin((a, b) -> (a.getEng()+a.getMath() <= b.getEng()+b.getMath()) ? a : b));
 }

	private static Student getMaxOrMin(BinaryOperator<Student> f) {
		Student result = list[0];
		for (Student s : list) {
			result = f.apply(result, s);
		}
		return result;
	}
}