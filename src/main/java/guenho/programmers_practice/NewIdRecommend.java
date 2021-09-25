package guenho.programmers_practice;

public class NewIdRecommend {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(new_id));
    }

    private static String solution(String new_id) {

        // case 1 : 대문자 -> 소문자
        new_id = new_id.toLowerCase();

        // case 2
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // case 3
        while(new_id.contains("..")) {
            new_id = new_id.replace("..",".");
        }

        // case 4
        if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        } else if (new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        System.out.println("new_id 4 = " + new_id);

        // case 5
        if (new_id.equals("") || new_id == null) {
            new_id = "a";
        }
        System.out.println("new_id 5 = " + new_id);

        // case 6
        if (new_id.length() >= 16) {

            new_id = new_id.substring(0, 15);

            if (new_id.substring(new_id.length() - 1).equals(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        System.out.println("new_id 6 = " + new_id);

        // case 7
        if (new_id.length() <= 2) {
            int len = new_id.length();
            char lastChar = new_id.charAt(new_id.length() - 1);

            System.out.println("new_id11 = " + new_id);
            System.out.println("len = " + len);

            while (len < 3) {
                len++;
                new_id += lastChar;
            }
        }

        System.out.println("new_id 7 = " + new_id);

        return new_id;
    }
}
