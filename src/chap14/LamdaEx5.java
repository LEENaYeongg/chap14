package chap14;

interface LambdaInterface5{
   void method();
}
class Outer{
   public int iv =10;//�ܺκ���
   void method() {
      int iv = 20;//�Լ���ü���� �������� ���ٽ� ���ȭ//��������
      //���������� ���ٸ� �ܺκ����� ��Ÿ��
      //iv++;//������
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