package guenho.practice;

public class Recursive {

    public static void main(String[] args) {
        System.out.println(fibonaci(10));
        System.out.println("test");
    }

    public static boolean fibonaci(int n) {
        if (n == 1) {
            System.out.println("fin : " + n);
            return false;
        }
        System.out.println("init : " + n);
        for(int i=0; i<4; i++){
            fibonaci(n-1);
            System.out.println("fibo : " + n);
        }

        return false;
    }
}
