package assn01;

public class Part3 {
    public static void main(String args[]){
        short sh = 32767;
        method2();
        method3();
    }
    public static void method2(){
        Integer n2 = 0xABC;
        System.out.println(n2);
    }
    public static void method3(){
        char[] a3 = new char[]{'a', 'z'};
        System.out.println(a3[0]+""+a3[1]);
    }
}