package guenho.programmers_practice;

public class Question1 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(new String(ch)).reverse().toString());
    }
}
