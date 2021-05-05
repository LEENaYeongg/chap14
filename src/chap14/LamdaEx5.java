package chap14;

interface LambdaInterface5{
   void method();
}
class Outer{
   public int iv =10;//외부변수
   void method() {
      int iv = 20;//함수객체에서 지역변수 접근시 상수화//지역변수
      //지역변수가 없다면 외부변수만 나타남
      //iv++;//에러남
      LambdaInterface5 f = ()->{
         System.out.println
         ("Outer.this.iv="+Outer.this.iv);
         System.out.println("this.iv="+this.iv);
         System.out.println("iv="+iv);
      };
      f.method();
   }
}
public class LamdaEx5 {

   public static void main(String[] args) {
      new Outer().method();
   }

}