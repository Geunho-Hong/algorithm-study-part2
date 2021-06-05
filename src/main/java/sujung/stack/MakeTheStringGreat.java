package sujung.stack;

public class MakeTheStringGreat {

    public String makeGood(String s) {

        StringBuilder sb = new StringBuilder();

        for (char current : s.toCharArray()) {
            if (sb.length() != 0 && Math.abs(current - sb.charAt(sb.length() - 1)) == 32) {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(current);
        }

        return sb.toString();
    }
}
