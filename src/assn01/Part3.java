package assn01;

public class Part3 {
    public static void main(String args[]){
        short sh = 32767;
        method2();
        method3();
    }
    public static void method2(){
        Integer n2 = 0xABC;
        int num1 = Integer.parseInt(n2.toString(),16);
        System.out.println(num1);
    }
    public static void method3(){
        String[] a3 = {"a", "z"};
        System.out.println(a3[0]+""+a3[1]);

    }
}
