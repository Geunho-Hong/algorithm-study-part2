package min.string.week2;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println("result = " + new ExcelSheetColumnNumber().titleToNumber("FXSHRXW"));
    }

    public int titleToNumber(String s) {
        int result = 0;

        // A B C
        // 1
        // 26 + 2
        // 28 * 26 + 3
        for (int i = 0; i < s.length(); i++)
            result = result * 26 + getCharValue(s.charAt(i));

        return result;
    }

    private int getCharValue(char c) {
        return c - 64;
    }

}
