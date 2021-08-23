package guenho.practice;

public class LoopTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.println("i= " + i + " j = " + j);
                /**
                 * break시 가장 안쪽의 반복문에서 빠져나온다
                 */
                if(j == 15) {
                    break;
                }
            }
        }
    }
}
