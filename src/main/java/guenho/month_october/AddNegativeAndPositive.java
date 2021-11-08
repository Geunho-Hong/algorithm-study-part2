package guenho.month_october;

public class AddNegativeAndPositive {
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};

        System.out.println(solution(absolutes,signs));
    }

    private static int solution(int[] absolutes, boolean[] signs){
        // true  : 양수
        // false : 음수

        int sum = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if(signs[i]) {
                sum += absolutes[i];
            } else {
                sum += -absolutes[i];
            }
        }

        return sum;
    }


}
