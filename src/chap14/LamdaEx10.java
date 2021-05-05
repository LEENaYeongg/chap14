package chap14;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
 * Predicate 인터페이스
 *   매개변수 존재. 리턴형은 boolean
 *   boolean test(T)
 *   
 */
public class LamdaEx10 {
   private static List<Student> list = Arrays.asList(
         new Student("홍길동",55,90,"경영"),
         new Student("이몽룡",95,90,"컴공"),
         new Student("김삿갓",75,80,"심리"),
         new Student("임꺽정",65,70,"전자"),
         new Student("성춘향",65,0,"컴공")
   );
   public static void main(String[] args) {
      System.out.println("영어점수 60 이상인 학생의 영어 평균: "
            +avg1(t->t.getEng()>=60));
      System.out.println("컴공과 학생의 영어 평균: "
              +avg1(t->t.getMajor().equals("컴공")));
      System.out.println("컴공과가 아닌 학생의 영어 평균: "
              +avg1(t->!t.getMajor().equals("컴공")));
      System.out.println("수학점수 60 이상인 학생의 수학 평균: "
              +avg2(t->t.getMath()>=60));
      System.out.println("컴공과 학생의 수학 평균: "
              +avg2(t->t.getMajor().equals("컴공")));
      System.out.println("컴공과가 아닌 학생의 수학 평균: "
              +avg2(t->!t.getMajor().equals("컴공")));
      //
      System.out.println("컴공과 학생의 이름:");
      namelist(t->t.getMajor().equals("컴공")); 
      System.out.println("컴공과 아닌 학생의 이름:");
      namelist(t->!t.getMajor().equals("컴공"));
      System.out.println("영어점수가 80이상인 학생의 이름:");
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