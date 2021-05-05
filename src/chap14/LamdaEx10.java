package chap14;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
 * Predicate �������̽�
 *   �Ű����� ����. �������� boolean
 *   boolean test(T)
 *   
 */
public class LamdaEx10 {
   private static List<Student> list = Arrays.asList(
         new Student("ȫ�浿",55,90,"�濵"),
         new Student("�̸���",95,90,"�İ�"),
         new Student("���",75,80,"�ɸ�"),
         new Student("�Ӳ���",65,70,"����"),
         new Student("������",65,0,"�İ�")
   );
   public static void main(String[] args) {
      System.out.println("�������� 60 �̻��� �л��� ���� ���: "
            +avg1(t->t.getEng()>=60));
      System.out.println("�İ��� �л��� ���� ���: "
              +avg1(t->t.getMajor().equals("�İ�")));
      System.out.println("�İ����� �ƴ� �л��� ���� ���: "
              +avg1(t->!t.getMajor().equals("�İ�")));
      System.out.println("�������� 60 �̻��� �л��� ���� ���: "
              +avg2(t->t.getMath()>=60));
      System.out.println("�İ��� �л��� ���� ���: "
              +avg2(t->t.getMajor().equals("�İ�")));
      System.out.println("�İ����� �ƴ� �л��� ���� ���: "
              +avg2(t->!t.getMajor().equals("�İ�")));
      //
      System.out.println("�İ��� �л��� �̸�:");
      namelist(t->t.getMajor().equals("�İ�")); 
      System.out.println("�İ��� �ƴ� �л��� �̸�:");
      namelist(t->!t.getMajor().equals("�İ�"));
      System.out.println("���������� 80�̻��� �л��� �̸�:");
      namelist(t->t.getEng() >= 80);
      
   }
   private static void namelist(Predicate<Student> p) {
	for(Student s : list) {
		if(p.test(s)) System.out.print(s.getName()+",");
	}
	
}
private static double avg2(Predicate<Student> p) {
	   int sum = 0,cnt=0;
	      for(Student s:list) {
	         if(p.test(s)) {
	            sum +=s.getMath();
	            cnt++;
	         }
	      }
	return (double)sum/cnt;
}
private static double avg1(Predicate<Student> p) {
      int sum = 0,cnt=0;
      for(Student s:list) {
         if(p.test(s)) {
            sum +=s.getEng();
            cnt++;
         }
      }
      return (double)sum/cnt;
   }
}